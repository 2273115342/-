package net.newture.dao;

import java.util.List;
import net.newture.domain.Role;

public interface RoleDao {
	/**
	 * 保存指定角色信息
	 * @param role 待保存角色
	 */
	public void save(Role role);

	/**
	 * 更新指定角色信息
	 * @param role 待更新角色
	 */
	public void update(Role role);

	/**
	 * 删除指定角色
	 * @param role 待删除角色
	 */
	public void delete(Role role);

	/**
	 * 根据主键编号查找角色
	 * @param id 主键编号
	 * @return
	 */
	public Role findById(Integer id);
	
	/**
	 * 查询所有角色列表
	 * @return
	 */
	public List<Role> findAll();
}
