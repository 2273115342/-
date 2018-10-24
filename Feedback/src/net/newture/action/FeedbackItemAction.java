package net.newture.action;


import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.FeedbackItem;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemService;

public class FeedbackItemAction extends ActionBase{
	
	private FeedbackItem feedbackItem;
	private Integer fiId;
	private String[] ids; //批量删除用户的id集合
	private String condName;
	private String condValue;
	

	@Autowired
	private FeedbackItemService feedbackItemService;
	

	public FeedbackItem getFeedbackItem() {
		return feedbackItem;
	}


	public void setFeedbackItem(FeedbackItem feedbackItem) {
		this.feedbackItem = feedbackItem;
	}


	public Integer getFiId() {
		return fiId;
	}


	public void setFiId(Integer fiId) {
		this.fiId = fiId;
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


	public String[] getIds() {
		return ids;
	}


	public void setIds(String[] ids) {
		this.ids = ids;
	}


	/**
	 * 新增反馈指标
	 * 
	 * @return
	 */
	public String add() {
		try {
			feedbackItemService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化反馈指标出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return "add";
		}

		return "add";
	}
	
	
	public String list() {
		feedbackItemService.findAllFeedbackItem();
		return "list";
	}
	
	/**
	 * 修改反馈指标项
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据fiId号获取反馈指标信息
			if (feedbackItem == null) {
				if ((feedbackItem = feedbackItemService.findFeedbackItemByfiId(fiId)) == null) {
					Struts2Utils.setAttribute("message", "修改反馈指标信息初始化出错：找不到指定反馈指标项");
					return ERROR;
				}
			}
			feedbackItemService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改反馈指标信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "edit";
	}
	
	
	/**
	 * 更新用户
	 * 
	 * @return
	 */
	public String update() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "updateCheckError";
		// 保存用户信息
		try {
			if (feedbackItemService.updateFeedbackItem(feedbackItem) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新反馈指标出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新反馈指标成功！");
		return SUCCESS;
	}
	
	
	/**
	 * 反馈指标项查询
	 * @return
	 */
	public String query() {
		try {
			feedbackItemService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}

		return "query";
	}
	
	
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "queryCheckError";
			}
			feedbackItem = feedbackItemService.findByCond(condName, condValue);
			feedbackItemService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (feedbackItem == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
	
	
	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (feedbackItemService.deleteFeedbackItem(fiId) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除反馈指标出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除反馈指标成功！");
		return SUCCESS;
	}

	
	
	/**
	* @Title: listDelete   
	* @Description: TODO(批量删除反馈指标)     
	* @return String    返回类型   
	*/
	public String batchDelete(){
	String state = null;
		state = feedbackItemService.batchDeleteFeedbackItem(ids);
		if(state.equals("success")){
			Struts2Utils.setAttribute("message", "批量删除反馈指标成功！");
			return SUCCESS;
		}
		System.out.println(state);
		Struts2Utils.setAttribute("message",state);
		return ERROR;
		
	}
	
	
	/**
	 * 保存反馈指标
	 * 
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "saveCheckError";
		// 保存用户信息
		try {
			if (feedbackItemService.saveFeedbackItem(feedbackItem) != 1)
				return "saveCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存反馈指标出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存反馈指标信息成功！");
		return SUCCESS;
	}
	
	
	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 * 
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (feedbackItem.getFiId() == null || feedbackItem.getFiId().equals("")) {
			Struts2Utils.setAttribute("message1", "反馈指标项编号不能为空！");
			return -1;
		}
		if (feedbackItem.getFeedbackItemType().getFitId() == null || feedbackItem.getFeedbackItemType().getFitId().equals("")) {
			Struts2Utils.setAttribute("message2", "反馈指标项类型编号不能为空!");
			return -1;
		}
		if (feedbackItem.getFiName() == null || feedbackItem.getFiName().equals("")) {
			Struts2Utils.setAttribute("message3", "反馈指标项名称不能为空!");
			return -1;
		}
		if (feedbackItem.getItemValue() == null || feedbackItem.getItemValue().equals("")) {
			Struts2Utils.setAttribute("message4", "指标项分值不能为空!");
			return -1;
		}
		return 1;
	}
	
}
