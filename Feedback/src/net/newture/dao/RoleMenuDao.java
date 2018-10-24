package net.newture.dao;

import java.util.List;
import java.util.Map;

import net.newture.domain.Menu;
import net.newture.domain.Role;

public interface RoleMenuDao {
	/**
	 * 保存指定角色菜单信息
	 * @param role 待保存角色
	 * @param menu 待保存菜单
	 * @param disporder 显示顺序
	 */
	public List save(Role role , Menu menu , Integer disporder);

	/**
	 * 更新指定角色菜单信息
	 * @param role 待更新角色
	 * @param menu 待更新菜单
	 * @param disporder 显示顺序
	 * @param rid 修改前的角色ID
	 * @param mid 修改前的菜单ID
	 */
	public List update(Role role , Menu menu , Integer disporder);

	/**
	 * 删除指定角色菜单
	 * @param role 待删除角色
	 * @param menu 待删除菜单
	 */
	public List delete(Role role , Menu menu );

	/**
	 * 根据主键编号查找角色菜单
	 * @param rid 角色主键编号
	 * @param mid 菜单主键编号
	 * @return
	 */
	public List findById(Integer rid , Integer mid );
	
	/**
	 * 查询所有角色菜单列表
	 * @return
	 */
	public List<Object[]> findAll();
	
	public Role findByRoleName (Integer rid);
	
	public Menu findByMenuName (Integer mid);
}
