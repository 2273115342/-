package net.newture.service;

import java.util.List;

import net.newture.domain.Department;
import net.newture.domain.Role;

public interface DepartmentService {
	/**
	 * 保存部门信息
	 * @param department 待保存部门
	 * @return 1：成功 -1：失败
	 */
	public int savedepartment(Department department);
	
	/**
	 * 获取部门代码表信息
	 * @return 
	 */
	public void getPartmentTable();
	
	/**
	 * 删除指定部门
	 * @param role 待删除部门
	 * @return 1：成功 -1：失败
	 */
	public int deleteDepartment(Integer id);
	
	/**
	 * 删除指定部门
	 * @param role 待删除部门
	 */
	public void deleteDepartment(Department department);
	
	/**
	 * 更新指定部门信息
	 * @param role 待更新部门
	 * @return 1：成功 -1：失败
	 */
	public int updateDepartment(Department department);
}
