package net.newture.dao;

import java.util.List;

import net.newture.domain.Role;
import net.newture.domain.User;

public interface UserRoleDao {
	public void save(User user);
	public void update(User user);

	public void delete(User user);

	/**
	 * 根据主键编号查找角色
	 * @param id 主键编号
	 * @return
	 */
	public User findById(Integer id);
	
	public List<User> findAll();
	
}
