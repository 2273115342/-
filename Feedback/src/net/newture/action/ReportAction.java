package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.ClassCourse;
import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportService;

public class ReportAction extends ActionBase {
	
	private ClassCourse classCourse;
	private String condName;
	private String condValue;
	private User user;
	
	@Autowired
	ReportService reportService;
	
	public ClassCourse getClassCourse() {
		return classCourse;
	}
	public void setClassCourse(ClassCourse classCourse) {
		this.classCourse = classCourse;
	}
	public ReportService getReportService() {
		return reportService;
	}
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	public String queryByCond() {
//		try {
//			if (condValue == null || condValue.trim().equals("")) {
//				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
//				return "queryCheckError";
//			}
//			user = userService.findByCond(condName, condValue);
//			userService.getCodeTable();
//		} catch (Exception e) {
//			Struts2Utils.setAttribute("message",
//					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
//							: "") + "<br/>"
//							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
//									: ""));
//			return ERROR;
//		}
//		if (user == null) {
//			return ERROR;
//		} else {
//			return "query";
//		}
//	}
	
	
	public String teacher() {
		reportService.teacher(user);
		return "list";
	}
	
	
	public String list () {
		
		return "list";
	}
}
