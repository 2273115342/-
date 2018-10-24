package net.newture.dao;

import java.util.List;


import net.newture.domain.FeedbackItem;
import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.domain.User;

public interface SysDao {
	
	/**
	 * 查询所有角色列表
	 * @return
	 */
	public List<Role> findAllRoles();
	
	/**
<<<<<<< .mine
	 * 查询所有反馈指标列表
	 * @return
	 */
	public List<FeedbackItem> findAllFeedbackItems();
	
	/**
	 * 查询所有班级列表
	 * @return
	 */
	public List<Class> findAllClasses();
	
	/**
	 * 查询所有部门列表
	 * @return
	 */
	public List<Department> findAllDepartment();
	
	/**
	 * 根据角色编号获取系统菜单
	 * @param roleId 角色编号
	 * @return List
	 */
	public List<Object[]> getSysMenuByRoleId(int roleId);
	
}
