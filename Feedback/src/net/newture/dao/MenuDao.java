package net.newture.dao;

import java.util.List;

import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;

/**
 * 操作系统菜单和角色菜单管理的dao接口类
 * @author js
 *  2018年6月23日 下午4:27:13
 */
public interface MenuDao {
	/**
	 * @Title: MenuCount   
	 * @Description: TODO(统计菜单总数)     
	 * @return List   返回类型
	 */
	public List MenuCount();
	
	/**
	 * @Title: findByAllMenu   
	 * @Description: TODO(查询所有的系统菜单)     
	 * @return List   返回类型
	 */
	public List findByAllMenu();
	
	/**
	 * @Title: findByMenuId   
	 * @Description: TODO(根据菜单id 查找菜单信息)     
	 * @return List   返回类型
	 */
	public List findByMenuId(Integer menuId);

	/**
	 * @Title: fineByMenuName   
	 * @Description: TODO(根据菜单name查找菜单信息)     
	 * @return List   返回类型
	 */
	public List fineByMenuName(String menuName);
	
	/**
	 * @Title: save   
	 * @Description: TODO(保存一个菜单信息)     
	 * @return void   返回类型
	 */
	public void save(Menu menu);
	
	/**
	 * @Title: update   
	 * @Description: TODO(更新一个菜单信息)     
	 * @return void   返回类型
	 */
	public void update(Menu menu);
	
	/**
	 * @Title: delete   
	 * @Description: TODO(删除系统菜单)     
	 * @return void   返回类型
	 */
	public void delete(Menu menu);
	
	/**
	 * @Title: findAllMenu   
	 * @Description: TODO(分页查询系统菜单)     
	 * @return List<Object[]>   返回类型
	 */
	public List findAllMenu(Object object,Integer offset,Integer length);
	
	/**
	 * @Title: findFirstMenu   
	 * @Description: TODO(查询首级菜单)     
	 * @return List<Menu>   返回类型
	 */
	public List<Object[]> findFirstMenu();
	
	/**
	 * @Title: findAllRoleMenu   
	 * @Description: TODO(查询所有角色菜单信息)     
	 * @return List<Object[]>   返回类型
	 */
	public List<Object[]> findAllRoleMenu();
	
	/**
	 * @Title: findByRoleIdNo   
	 * @Description: TODO(根据角色id查找角色没有的菜单信息)     
	 * @return List<Object[]>   返回类型
	 */
	public List<Object[]> findByRoleIdNo(Object [] objects);
	
	/**
	 * @Title: findByRoleId   
	 * @Description: TODO(根据角色id查找角色的菜单信息)     
	 * @return List<Object[]>   返回类型
	 */
	public List<Object[]> findByRoleId(Object [] objects);
	
	/**
	 * @Title: update   
	 * @Description: TODO(修改角色菜单)     
	 * @return void   返回类型
	 */
	public void updateRoleMenu(RoleMenu roleMenu) ;
	
	/**
	 * @Title: saveRoleMenu   
	 * @Description: TODO(新增角色菜单信息)     
	 * @return void   返回类型
	 */
	public void saveRoleMenu(RoleMenu roleMenu);
	/**
	 * @Title: deleteRoleMenu   
	 * @Description: TODO(删除角色菜单信息)     
	 * @return void   返回类型
	 */
	public void deleteRoleMenu(RoleMenu roleMenu);
	/**
	 * @Title: findByRoleMenuId   
	 * @Description: TODO(根据角色菜单id查询角色菜单信息)     
	 * @return List<Object>   返回类型
	 */
	public List<Object[]> findByRoleMenuId(Integer roleMenuId);
}
