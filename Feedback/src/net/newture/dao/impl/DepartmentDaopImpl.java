package net.newture.dao.impl;

import java.util.List;

import net.newture.dao.DepartmentDao;
import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.framework.DaoBase;

import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaopImpl extends DaoBase implements DepartmentDao{
	@Override
	public void save(Department department){
		hibernateTemplate.save(department);
	}

	@Override
	public Department findByDepartmentName(String DepartmentName) {
		List list = hibernateTemplate.find("from Department where dept_Name = ?", DepartmentName);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (Department) list.get(0);
		}
	}
	
	@Override
	public List<Department> findAllDepartments() {
		return hibernateTemplate.find("from Department order by dept_id");
	}

	@Override
	public void delete(Department department) {
		hibernateTemplate.delete(department);		
	}

	@Override
	public Department findById(Integer id) {
		return hibernateTemplate.get(Department.class, id);
	}

	@Override
	public void update(Department department) {
		hibernateTemplate.update(department);		
	}
}
