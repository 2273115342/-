package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.FeedbackItemType;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemTypeService;

public class FeedbackItemTypeAction extends ActionBase{
	private FeedbackItemType feedbackItemType;
	private Integer id;
	private String[] ids; //批量删除用户的id集合
	private String condName;
	private String condValue;
	
	@Autowired 
	FeedbackItemTypeService feedbackItemTypeService;

	public FeedbackItemType getFeedbackItemType() {
		return feedbackItemType;
	}

	public void setFeedbackItemType(FeedbackItemType feedbackItemType) {
		this.feedbackItemType = feedbackItemType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}

	public FeedbackItemTypeService getFeedbackItemTypeService() {
		return feedbackItemTypeService;
	}

	public void setFeedbackItemTypeService(
			FeedbackItemTypeService feedbackItemTypeService) {
		this.feedbackItemTypeService = feedbackItemTypeService;
	}

	/**
	 * 新增反馈类别页面打开
	 * 
	 * @return
	 */
	public String add() {
		return "add";
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "saveCheckError";
		// 保存信息
		try {
			if (feedbackItemTypeService.saveFeedbackItemType(feedbackItemType) != 1)
				return "saveCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "新增反馈类别信息成功！");
		return "success";
	}

	/**
	 * 修改反馈类别
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (feedbackItemType == null) {
				if ((feedbackItemType = feedbackItemTypeService.findFeedbackItemTypeById(id)) == null) {
					Struts2Utils.setAttribute("message", "修改信息初始化出错：找不到指定信息");
					return ERROR;
				}
			}
			feedbackItemTypeService.updateFeedbackItemType(feedbackItemType);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "edit";
	}


	/**
	 * 更新反馈类别
	 * 
	 * @return
	 */
	public String update() {
		// 保存信息
		try {
			if (feedbackItemTypeService.updateFeedbackItemType(feedbackItemType) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新反馈类别信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新反馈类别信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 * 
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (feedbackItemType.getFitName() == null || feedbackItemType.getFitName().trim().equals("")) {
			Struts2Utils.setAttribute("message1", "名称不能为空！");
			return -1;
		}
		return 1;
	}

	/**
	 * 删除反馈类别
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (feedbackItemTypeService.deleteFeedbackItemType(id) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除信息成功！");
		return SUCCESS;
	}
	
	/**
	* @Title: listDelete   
	* @Description: TODO(批量删除)     
	* @return String    返回类型   
	*/
	public String batchDelete(){
	String state = null;
		state = feedbackItemTypeService.batchDeleteFeedbackItemType(ids);
		if(state.equals("success")){
			Struts2Utils.setAttribute("message", "批量删除信息成功！");
			return SUCCESS;
		}
		System.out.println(state);
		Struts2Utils.setAttribute("message",state);
		return ERROR;
		
	}

	public String list() {
		feedbackItemTypeService.findAllFeedbackItemType();;
		return "list";
	}
	
	public String query (){
		return "query";
	}
	
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "queryCheckError";
			}
			feedbackItemType = feedbackItemTypeService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (feedbackItemType == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
}
