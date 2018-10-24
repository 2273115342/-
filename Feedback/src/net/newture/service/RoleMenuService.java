package net.newture.service;

import net.newture.domain.Menu;
import net.newture.domain.Role;

public interface RoleMenuService {
	/**
	 *	保存角色菜单信息
	 * @param role 待保存角色
	 * @param menu 待保存菜单
	 * @return 1：成功 -1：失败
	 */
	public int saveRoleMenu(Role role, Menu menu ,Integer disporder);
	
	/**
	 * 更新指定角色菜单信息
	 * @param role 待更新角色
	 * @param menu 待更新菜单
	 * @return 1：成功 -1：失败
	 */
	public int updateRoleMenu(Role role, Menu menu, Integer disporder);

	/**
	 * 删除指定角色菜单
	 * @param role 待删除角色
	 * @param menu 待删除菜单
	 */
	public void deleteRoleMenu(Role role  , Menu menu);
	
	/**
	 * 删除指定角色菜单
	 * @param rid 待删除角色
	 * @param mid 待删除菜单
	 * @return 1：成功 -1：失败
	 */
	public int deleteRoleMenu(Integer rid , Integer mid);

	/**
	 * 获取所有角色菜单列表
	 */
	public void findAllRoleMenu();
}
