package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.RoleDao;
import net.newture.domain.Role;
import net.newture.framework.DaoBase;

@Repository
public class RoleDaoImpl extends DaoBase implements RoleDao {
	
	public void save(Role role) {
		hibernateTemplate.save(role);
	}
	
	public void update(Role role) {
		hibernateTemplate.update(role);
	}
	
	public void delete(Role role) {
		hibernateTemplate.delete(role);
	}
	
	public Role findById(Integer id) {
		return hibernateTemplate.get(Role.class, id);
	}
	
	public List<Role> findAll() {
		return hibernateTemplate.find("from Role order by roleId");
	}
}
