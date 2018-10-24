package net.newture.service;

import java.util.List;

import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;

/**
 * 用一句话来描述这个类的作用
 * @author js
 *  2018年6月23日 下午4:35:14
 */
public interface MenuService {
	/**
	 * @Title: saveMenu   
	 * @Description: TODO(保存一个传入进来的菜单)     
	 * @return int   返回类型(1为成功 -1为失败)
	 */
	public int saveMenu(Menu menu);
	
	/**
	 * @Title: findByAllMenu   
	 * @Description: TODO(查询所有的系统菜单)     
	 * @return void   返回类型
	 */
	public void findByAllMenu();
	
	/**
	 * @Title: deleteMenu   
	 * @Description: TODO(删除指定的菜单)     
	 * @return void   返回类型
	 */
	public void deleteMenu(Integer menuId);
	
	/**
	 * @Title: batchDeleteMenu   
	 * @Description: TODO(批量删除菜单)     
	 * @return void   返回类型
	 */
	public int batchDeleteMenu(String[]menuId);
	
	/**
	 * @Title: updateMenu   
	 * @Description: TODO(更新一个传入进来的菜单)     
	 * @return void 
	 */
	public void updateMenu(Menu menu);
	
	/**
	 * @Title: findByMenuId   
	 * @Description: TODO(根据传入的菜单ID查询菜单信息)     
	 * @return int   返回类型(1为成功 -1为失败)
	 */
	public Menu findByMenuId(Integer menuId);
	
	/**
	 * @Title: fineByMenuName   
	 * @Description: TODO(根据菜单名查找菜单信息)     
	 * @return void   返回类型
	 */
	public void fineByMenuName(String menuName);
	
	/**
	 * @Title: findAllMenu   
	 * @Description: TODO(分页查询菜单信息)     
	 * @return void   返回类型
	 */
	public void findAllMenu(Integer currentPage,Integer length);
	
	/**
	 * @Title: findFirstMenu   
	 * @Description: TODO(查询首级菜单)     
	 * @return List<Menu>   返回类型
	 */
	public List<Object[]> findFirstMenu();
	/**
	 * @Title: findAllRoleMenu   
	 * @Description: TODO(初始化角色菜单管理界面)     
	 * @return int   返回类型
	 */
	public int findAllRoleMenu();
	/**
	 * @Title: findByRoleIdNo   
	 * @Description: TODO(根据角色id查找角色没有的菜单信息)     
	 * @return int   返回类型(1：查找成功 -1：失败)
	 */
	public int findByRoleIdNo(Integer roleId);
	/**
	 * @Title: findByRoleIdNo   
	 * @Description: TODO(根据角色id查找角色菜单信息)     
	 * @return int   返回类型(1：查找成功 -1：失败)
	 */
	public int findByRoleId(Integer roleId);
	/**
	 * @Title: updateRoleMenu   
	 * @Description: TODO(修改角色菜单)     
	 * @return int   返回类型
	 */
	public int updateRoleMenu(RoleMenu roleMenu);
	/**
	 * @Title: saveRoleMenu   
	 * @Description: TODO(新增角色菜单)     
	 * @return int   返回类型
	 */
	public int saveRoleMenu(RoleMenu roleMenu);
	/**
	 * @Title: batchIncreaseRoleMenu   
	 * @Description: TODO(角色菜单管理的批量增加)     
	 * @return void   返回类型
	 */
	public void batchIncreaseRoleMenu(String addMenuId[],int roleId);
	/**
	 * @Title: batchDeletionRoleMenu   
	 * @Description: TODO(角色菜单管理的批量删除)     
	 * @return void   返回类型
	 */
	public void batchDeletionRoleMenu(String deleteMenuId[],String rmId[],int roleId);
}
