package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.UserRoleDao;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.DaoBase;
@Repository
public class UserRoleDaoImpl extends DaoBase implements UserRoleDao {

	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User findById(Integer id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return hibernateTemplate.find("from User order by userId");
	}

}
