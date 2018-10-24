package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.RoleDao;
import net.newture.domain.Role;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleService;

@Service
public class RoleServiceImpl extends ServiceBase implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Transactional
	public int saveRole(Role role) {
		this.roleDao.save(role);
		return 1;
	}

	@Transactional
	public int updateRole(Role role) {
		// 更新用户信息
		this.roleDao.update(role);
		return 1;
	}

	@Transactional
	public void deleteRole(Role role) {
		this.roleDao.delete(role);
		Struts2Utils.setAttribute("message", "删除用户信息成功！");
	}
	
	@Override
	@Transactional
	public int deleteRole(Integer id) {
		// 根据主键编号查找用户对象
		Role role = roleDao.findById(id);
		if (role == null) {
			Struts2Utils.setAttribute("message", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			roleDao.delete(role);
			return 1;
		}
	}

	public void findAllRole() {
		List<Role> roles = this.roleDao.findAll();
		Struts2Utils.setAttribute("roles", roles);
	}
}
