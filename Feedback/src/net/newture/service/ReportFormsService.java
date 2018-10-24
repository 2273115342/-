package net.newture.service;
/**
 * 用一句话来描述这个类的作用
 * @author js
 *  2018年7月1日 上午12:01:26
 */
public interface ReportFormsService {
	/**
	 * @Title: findReportForms   
	 * @Description: TODO(根据班级id查询报表)     
	 * @return void   返回类型
	 */
	public void findReportForms(Integer classId);
	
	/**
	 * @Title: findAllClasses   
	 * @Description: TODO(查询所有班级信息)     
	 * @return void   返回类型
	 */
	public void findAllClasses();
	
	/**
	 * @Title: findByAccomplishFeed   
	 * @Description: TODO(根据班级id查询已完成的教学反馈)     
	 * @return void   返回类型
	 */
	public void findByAccomplishFeed(Integer classId);
}
