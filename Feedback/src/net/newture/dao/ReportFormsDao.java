package net.newture.dao;

import java.util.List;

import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;

/**
 * 报表管理的Dao
 * @author js
 *  2018年6月30日23:51:56
 */
public interface ReportFormsDao {
	/**
	 * @Title: findReportForms   
	 * @Description: TODO(根据班级id查询报表)     
	 * @return List   返回类型
	 */
	public List findReportForms(Integer classId);
	
	/**
	 * @Title: findAllClasses   
	 * @Description: TODO(查询所有班级信息，以后用班级Dao里的 现在不该改别人的代码)     
	 * @return List   返回类型
	 */
	public List findAllClasses();
	
	/**
	 * @Title: findByAccomplishFeed   
	 * @Description: TODO(根据班级id查询已完成的教学反馈)     
	 * @return List   返回类型
	 */
	public List findByAccomplishFeed(Integer classId);
}
