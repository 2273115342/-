package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.DepartmentDao;
import net.newture.dao.SysDao;
import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends ServiceBase implements DepartmentService{
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional
	public int savedepartment(Department department){
		// 校验部门名是否存在
		Department findDep=departmentDao.findByDepartmentName(department.getDeptName());
		if (findDep != null) {
			Struts2Utils.setAttribute("msg1", "该部门存在！");
			return -1;
		}
		this.departmentDao.save(department);
		return 1;
	}
	
	@Override
	public void getPartmentTable() {
		// 获取用户角色列表
		List<Department> departments = departmentDao.findAllDepartments();
		// 保存准备遍历
		Struts2Utils.setAttribute("departments", departments);
	}

	@Override
	@Transactional
	public int deleteDepartment(Integer id) {
		// 根据主键编号查找用户对象
		Department department = departmentDao.findById(id);
		if (department == null) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			departmentDao.delete(department);
			return 1;
		}
	}

	@Transactional
	public void deleteDepartment(Department department) {
		this.departmentDao.delete(department);
		Struts2Utils.setAttribute("msg", "删除用户信息成功！");
	}

	@Override
	public int updateDepartment(Department department) {
		this.departmentDao.update(department);
		return 1;
	}
}
