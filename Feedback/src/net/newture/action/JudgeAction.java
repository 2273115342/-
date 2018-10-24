package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Judge;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.JudgeService;

public class JudgeAction extends ActionBase{

	private Judge judge;
	private Integer judgeId;
	private String request;
	private Integer Point;
	private String condName;
	private String condValue;

	public String getCondValue() {
		return condValue;
	}
	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}

	private String[] ids;

	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getjudgeId() {
		return judgeId;
	}
	public void setId(Integer judgeid) {
		judgeId = judgeid;
	}
	public String getRequestn() {
		return condName;
	}
	public void setRequestn(String Requestn) {
		this.condName = Requestn;
	}
	
	
	@Autowired
	JudgeService judgeService;
	
	public Judge getJudge() {
		return judge;
	}
	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	public Integer getJudgeId() {
		return judgeId;
	}
	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Integer getPoint() {
		return Point;
	}
	public void setPoint(Integer point) {
		Point = point;
	}
	public JudgeService getJudgeService() {
		return judgeService;
	}
	public void setJudgeService(JudgeService judgeService) {
		this.judgeService = judgeService;
	}
		

	/**
	 * @Title: add   
	 * @Description: TODO(进入评分页面)     
	 * @return String   返回类型
	 */
	

	public String add() {
		
		return "add";
	}
	
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1)
		return "saveCheckError";
		// 保存课程信息
		try {
			if(judgeService.saveJudge(judge) !=1) return "saveCheckError";
			
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存用户信息成功！");
		return SUCCESS;
	}

	public String judge(){
		 return "judge";
	}
	

	/**
	 * 更新课程
	 * 
	 * @return
	 */
	public String update() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "updateCheckError";
		// 保存用户信息
		try {
			if (judgeService.updateJudge(judge) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新课程信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 * 
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (judge.getRequest() == null || judge.getRequest().trim().equals("")) {
			Struts2Utils.setAttribute("message", "用户名不能为空！");
			return -1;
		}
		return 1;
	}
	
//	public String save() {
//		// 校验必录信息项
//		if (judge.getJudge() == null || judge.getJudge().trim().equals("")) {
//			Struts2Utils.setAttribute("message", "评分名不能为空！");
//			return ERROR;
//		}
//		// 保存角色信息
//		try {
//			if (judgeService.saveJudge(judge) != 1)
//				return ERROR;
//		} catch (Exception e) {
//			Struts2Utils.setAttribute("message",
//					"保存角色信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
//							: "") + "<br/>"
//							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
//									: ""));
//			return ERROR;
//		}
//		Struts2Utils.setAttribute("message", "保存角色信息成功！");
//		return SUCCESS;
//	}
//	
	/**
	 * 删除角色
	 * 
	 * @return
	 */
	public String delete() {
		try {
			judgeService.deleteJudge(judge);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除评分项出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除评分项成功！");
		return SUCCESS;
	}

	public String list() {
		judgeService.findAllJudge();
		return "list";
	}
	
//	
//	/**
//	 * 删除用户
//	 * 
//	 * @return
//	 */
//	public String delete() {
//		try {
//			if (judgeService.deleteJudge(judgeId) != 1)
//				return ERROR;
//		} catch (Exception e) {
//			Struts2Utils.setAttribute("message",
//					"删除用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
//							: "") + "<br/>"
//							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
//									: ""));
//			return ERROR;
//		}
//		Struts2Utils.setAttribute("message", "删除用户信息成功！");
//		return SUCCESS;
//	}

	/**
	 * 保存课程
	 * 
	 * @return
	 */

//	public String save() {
//		// 校验必录信息项
//		if (checkFormInput() != 1)
//			return "saveCheckError";
//		// 保存课程信息
//		try {
//			if (judgeService.savejudge(judge) != 1)
//				return "saveCheckError";
//		} catch (Exception e) {
//			Struts2Utils.setAttribute("message",
//					"保存评分项出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
//							: "") + "<br/>"
//							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
//									: ""));
//			return ERROR;
//		}
//		Struts2Utils.setAttribute("message", "保存评分项成功！");
//		return SUCCESS;
//	}
//	
//	private int checkFormInput() {
//		if (judge.getJudge() == null || judge.getJudge().equals("")) {
//			Struts2Utils.setAttribute("message1", "评分项不能为空!");
//			return -1;
//		}
//		if (judge.getRequest() == null || judge.getRequest().trim().equals("")) {
//			Struts2Utils.setAttribute("message2", "评分要求不能为空！");
//			return -1;
//		}
//		return 1;
//	}
//	
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		try {
			judgeService.getCodeTable();
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
			judge = judgeService.findByCond(judge, condValue);
			judgeService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (judge == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
}



//<!-- 评分管理 -->
//<action name="judgeAction_*" class="net.newture.action.JudgeAction"
//	method="{1}">
//	<result name="add">judgeAction_add</result>
//	<result name="delete">/pages/feedback/end.jsp</result>
//	<result name="judge">judgeAction_judge</result>
//	<result name="query">judgeAction_query</result>			
//</action>

//http://localhost:8080/Feedback/index