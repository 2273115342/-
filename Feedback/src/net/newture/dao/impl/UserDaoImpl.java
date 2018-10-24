package net.newture.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import net.newture.dao.UserDao;
import net.newture.domain.User;
import net.newture.framework.DaoBase;

@Repository
public class UserDaoImpl extends DaoBase implements UserDao {
	
	public void save(User user) {
		hibernateTemplate.save(user);
	}
	
	public void update(User user) {
		hibernateTemplate.update(user);
	}
	
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}
	
	public User findById(Integer id) {
		return hibernateTemplate.get(User.class, id);
	}
	
	@Override
	public User findByLoginName(String loginName) {
		List list = hibernateTemplate.find("from User where loginName = ?", loginName);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}
	
	public List<User> findByCond(String condName,Object condValue) {
		String hql = "from User where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}
	
	public List<User> findAll() {
		return hibernateTemplate.find("from User where status=1 order by name");
	}
	
	@Override
	public int countByLoginNameAndPwd(String loginName, String pwd) {
		String hql = "select count(*) from User where loginName = ? and password = ?";
		return ((Long)getSingleResult(hql, new Object[]{loginName, pwd })).intValue();
	}
	
}
