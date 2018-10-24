package net.newture.service;

import net.newture.domain.Role;

public interface RoleService {
	/**
	 * 保存角色信息
	 * @param role 待保存角色
	 * @return 1：成功 -1：失败
	 */
	public int saveRole(Role role);

	/**
	 * 更新指定角色信息
	 * @param role 待更新角色
	 * @return 1：成功 -1：失败
	 */
	public int updateRole(Role role);

	/**
	 * 删除指定角色
	 * @param role 待删除角色
	 */
	public void deleteRole(Role role);
	
	/**
	 * 删除指定角色
	 * @param role 待删除角色
	 * @return 1：成功 -1：失败
	 */
	public int deleteRole(Integer id);

	/**
	 * 获取所有角色列表
	 */
	public void findAllRole();
	
}
