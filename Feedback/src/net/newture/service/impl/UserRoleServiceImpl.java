package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.UserRoleDao;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserRoleService;
@Service
public class UserRoleServiceImpl extends ServiceBase implements UserRoleService {
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	public int saveUser(User user) {
		userRoleDao.save(user);
		return 1;
	}

	@Override
	public int updateUser(User user) {
		User user1 = userRoleDao.findById(user.getUserId());
		user.setLoginName(user1.getLoginName());
		user.setPassword(user1.getPassword());
		user.setAddress(user1.getAddress());
		user.setBirthday(user1.getBirthday());
		user.setIdcard(user1.getIdcard());
		user.setName(user1.getName());
		user.setSex(user1.getSex());
		user.setStatus(user1.getStatus());
		user.setUserType(user1.getUserType());
		userRoleDao.update(user);
		return 1;
	}

	@Override
	public void deleteUser(User user) {
		userRoleDao.update(user);
	}

	@Override
	public int deleteRole(Integer id) {
		// 根据主键编号查找用户对象
		User user = userRoleDao.findById(id);
		Role role = user.getRole();
		role.setRoleId(0);
		user.setRole(role);
		if (user == null) {
			Struts2Utils.setAttribute("message", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			userRoleDao.update(user);
			return 1;
		}
	}
	
	public User findById(int id) {
		return userRoleDao.findById(id);
	}

	@Override
	public void findAllUser() {
		List<User> Users = this.userRoleDao.findAll();
		Struts2Utils.setAttribute("Users", Users);
	}
}
