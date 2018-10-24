package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportFormsService;

public class ReportFormsAction extends ActionBase {
	
	private static final long serialVersionUID = -1880299931131590518L;

	@Autowired
	private ReportFormsService reportFormsService;
	
	/**
	 * @Title: findReportForms   
	 * @Description: TODO(根据班级id查询相应的报表)     
	 * @return String   返回类型
	 */
	public String findReportForms(){
		try {
			reportFormsService.findReportForms(Integer.valueOf(Struts2Utils.getParameter("classId")));
			reportFormsService.findByAccomplishFeed(Integer.valueOf(Struts2Utils.getParameter("classId")));
			Struts2Utils.setAttribute("byClass", "1");
		} catch (Exception e) {
			e.printStackTrace();
			Struts2Utils.setAttribute("message", "查询失败："+e);
		}
		return "findReportForms";
	}
	
	/**
	 * @Title: fingAllClasses   
	 * @Description: TODO(查询所有班级信息)     
	 * @return String   返回类型
	 */
	public String fingAllClasses(){
		try {
			reportFormsService.findAllClasses();
		} catch (Exception e) {
			e.printStackTrace();
			Struts2Utils.setAttribute("message", "查询失败："+e);
		}
		return "fingByClass";
	}
}
