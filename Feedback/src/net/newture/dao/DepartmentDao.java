package net.newture.dao;

import java.util.List;

import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.domain.User;

public interface DepartmentDao {
	/**
	 * 保存指定部门信息
	 * 
	 * @param department
	 *            待保存部门
	 */
	public void save(Department department);
	
	/**
	 * 查找是否有重复部门名
	 * 
	 * @param DepartmentName
	 *            部门名
	 * @return Department对象
	 */
	public Department findByDepartmentName(String DepartmentName);
	
	/**
	 * 查询所有部门列表
	 * 
	 * @return
	 */
	public List<Department> findAllDepartments();
	
	/**
	 * 删除指定部门
	 * @param role 待删除部门
	 */
	public void delete(Department department);

	/**
	 * 根据主键编号查找部门
	 * @param id 主键编号
	 * @return
	 */
	public Department findById(Integer id);
	
	/**
	 * 更新指定部门信息
	 * @param role 待更新部门
	 */
	public void update(Department department);
}
