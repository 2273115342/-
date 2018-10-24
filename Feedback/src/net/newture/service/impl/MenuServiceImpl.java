package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.MenuDao;
import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.MenuService;

/**
 * 用一句话来描述这个类的作用
 * @author js
 *  2018年6月23日 下午4:37:55
 */
@Service
public class MenuServiceImpl extends ServiceBase implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Transactional
	public int saveMenu(Menu menu) {
		menuDao.save(menu);
		return 1;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public void findAllMenu(Integer currentPage,Integer length) {
		List<Menu> list = menuDao.findAllMenu(new Menu(), currentPage*length, length);
		List<Object[]> objects = menuDao.MenuCount();
		int count = Integer.valueOf(objects.get(0)+"");
		int overallPageCount = 0;
		if(count%length==0)
			overallPageCount = count/length-1;
		else
			overallPageCount = count/length;
		Struts2Utils.setAttribute("currentPage", currentPage);
		Struts2Utils.setAttribute("overallPageCount", overallPageCount);
		Struts2Utils.setAttribute("MenuList", list);
	}

	@Transactional(readOnly = true)
	public List<Object[]> findFirstMenu() {
		List<Object[]> list = menuDao.findFirstMenu();
		List<Menu> firstMenuList = new ArrayList<Menu>();
		for(int i=0;i<list.size();i++){
			Menu menu = new Menu();
			Object[]object = (Object[])list.get(i);
			if(object[0]!=null)  menu.setMenuId(Integer.valueOf(object[0].toString()));
			if(object[1]!=null)  menu.setMenuName((String)object[1]);
			firstMenuList.add(menu);
		}
		Struts2Utils.setAttribute("firstMenuList", firstMenuList);
		return list;
	}

	@Transactional(readOnly = true)
	public int findByRoleIdNo(Integer roleId) {
		List<Object[]> list = new ArrayList<Object[]>();
		list = menuDao.findByRoleIdNo(new Object[]{roleId});
		List<RoleMenu> roleMenulist = new ArrayList<RoleMenu>();
		for(Object[] object : list){
			RoleMenu roleMenu = new RoleMenu();
			if(object[0]!=null)
				roleMenu.setRoleName(object[0].toString());
			if(object[1]!=null) 
				roleMenu.setRoleId(Integer.valueOf(object[1].toString()));
			if(object[2]!=null)
				roleMenu.setMenuId(Integer.valueOf(object[2].toString()));
			if(object[3]!=null)
				roleMenu.setMenuName(object[3].toString());
			if(object[4]!=null)
				roleMenu.setDispOrder(Integer.valueOf(object[4].toString()));
			if(object[5]!=null) 
				roleMenu.setRmId(Integer.valueOf(object[5].toString()));
			if(object[6]!=null) 
				roleMenu.setParentMenuId(Integer.valueOf(object[6].toString()));
			roleMenulist.add(roleMenu);
		}
		if(roleMenulist.size()>0)
			Struts2Utils.setAttribute("roleNoMenulist", roleMenulist);
		return 1;
	}
	
	@Override
	@Transactional(readOnly = true)
	public int findByRoleId(Integer roleId) {
		List<Object[]> list = new ArrayList<Object[]>();
		list = menuDao.findByRoleId(new Object[]{roleId});
		List<RoleMenu> roleMenulist = new ArrayList<RoleMenu>();
		for(Object[] object : list){
			RoleMenu roleMenu = new RoleMenu();
			if(object[0]!=null)
				roleMenu.setRoleName(object[0].toString());
			
			if(object[1]!=null)
				roleMenu.setRoleId(Integer.valueOf(object[1].toString()));
			
			if(object[2]!=null)
				roleMenu.setMenuId(Integer.valueOf(object[2].toString()));
			
			if(object[3]!=null)
				roleMenu.setMenuName(object[3].toString());
			
			if(object[4]!=null)
				roleMenu.setDispOrder(Integer.valueOf(object[4].toString()));
			
			if(object[5]!=null)
				roleMenu.setRmId(Integer.valueOf(object[5].toString()));
			
			if(object[6]!=null)
				roleMenu.setParentMenuId(Integer.valueOf(object[6].toString()));
			roleMenulist.add(roleMenu);
		}
		if(roleMenulist.size()>0)
			Struts2Utils.setAttribute("roleMenulist", roleMenulist);
		return 1;
	}

	@Override
	@Transactional(readOnly = true)
	public int findAllRoleMenu() {
		List<Object[]> list = menuDao.findAllRoleMenu();
		List<RoleMenu> roleMenulist = new ArrayList<RoleMenu>();
		for(Object[] object : list){
			RoleMenu roleMenu = new RoleMenu();
			if(object[0]!=null)
				roleMenu.setRoleName(object[0].toString());
			
			if(object[1]!=null)
				roleMenu.setRoleId(Integer.valueOf(object[1].toString()));
			
			if(object[2]!=null)
				roleMenu.setMenuId(Integer.valueOf(object[2].toString()));
			
			if(object[3]!=null)
				roleMenu.setMenuName(object[3].toString());
			
			if(object[4]!=null)
				roleMenu.setDispOrder(Integer.valueOf(object[4].toString()));
			
			if(object[5]!=null)
				roleMenu.setRmId(Integer.valueOf(object[5].toString()));
			
			if(object[6]!=null)
				roleMenu.setParentMenuId(Integer.valueOf(object[6].toString()));
			roleMenulist.add(roleMenu);
		}
		Struts2Utils.setAttribute("roleMenulist", roleMenulist);	
		return 1;
	}
	
	@Override
	@Transactional
	public int updateRoleMenu(RoleMenu roleMenu) {
		try {
			menuDao.updateRoleMenu(roleMenu);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	@Transactional
	public int saveRoleMenu(RoleMenu roleMenu) {
		try {
			menuDao.saveRoleMenu(roleMenu);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	@Transactional
	public void batchIncreaseRoleMenu(String[] addMenuId, int roleId) {
		for(String menuid : addMenuId){
			RoleMenu rm = new RoleMenu();
			rm.setRoleId(roleId);
			rm.setMenuId(Integer.valueOf(menuid));
			rm.setDispOrder(Integer.valueOf(menuid));
			this.saveRoleMenu(rm);
		}
	}

	@Override
	@Transactional
	public void batchDeletionRoleMenu(String[] deleteMenuId, String[] rmId,
			int roleId) {
		for(int i = 0 ; i < deleteMenuId.length ; i++){
			RoleMenu rm = new RoleMenu();
			List<Object[]> list = menuDao.findByRoleMenuId(Integer.valueOf(rmId[i]));
			for (Object[] object : list) {
				rm.setRmId(Integer.valueOf(object[0].toString()));
				rm.setRoleId(Integer.valueOf(object[1].toString()));
				rm.setMenuId(Integer.valueOf(object[2].toString()));
				rm.setDispOrder(Integer.valueOf(object[3].toString()));
			}
			menuDao.deleteRoleMenu(rm);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Menu findByMenuId(Integer menuId) {
		List<Object[]> list= menuDao.findByMenuId(menuId);
		Menu menu = new Menu();
		for(Object[]objects : list){
			if(objects[0]!=null) 
				menu.setMenuId(Integer.valueOf(objects[0]+""));
			if(objects[1]!=null) 
				menu.setMenuName(objects[1]+"");
			if(objects[2]!=null) 
				menu.setUrl(objects[2]+"");
			if(objects[3]!=null) 
				menu.setMenuIcon(objects[3]+"");
			if(objects[4]!=null) 
				menu.setParentMenuId(Integer.valueOf(objects[4]+""));
			if(objects[5]!=null) 
				menu.setValidFlag(Integer.valueOf(objects[5]+""));
			if(objects[6]!=null) 
				menu.setMenuDesc(objects[6]+"");
		}
		Struts2Utils.setAttribute("MenuList", menu);
		return menu;
	}

	@Override
	@Transactional(readOnly = true)
	public void fineByMenuName(String manuName) {
		List<Object[]> list= menuDao.fineByMenuName(manuName);
		List<Menu> menus = new ArrayList<Menu>();
		for(Object[]objects : list){
			Menu menu = new Menu();
			if(objects[0]!=null) 
				menu.setMenuId(Integer.valueOf(objects[0]+""));
			if(objects[1]!=null) 
				menu.setMenuName(objects[1]+"");
			if(objects[2]!=null) 
				menu.setUrl(objects[2]+"");
			if(objects[3]!=null) 
				menu.setMenuIcon(objects[3]+"");
			if(objects[4]!=null) 
				menu.setParentMenuId(Integer.valueOf(objects[4]+""));
			if(objects[5]!=null) 
				menu.setValidFlag(Integer.valueOf(objects[5]+""));
			if(objects[6]!=null) 
				menu.setMenuDesc(objects[6]+"");
			menus.add(menu);
		}
		Struts2Utils.setAttribute("MenuList", menus);
	}
	
	@Override
	@Transactional
	public void updateMenu(Menu menu) {
		menuDao.update(menu);
	}


	@Override
	@Transactional
	public void deleteMenu(Integer menuId) {
		Menu menu = findByMenuId(menuId);
		menuDao.delete(menu);
	}


	@Override
	public int batchDeleteMenu(String[] menuId) {
		StringBuffer deleteMenu = new StringBuffer();
		for (int i = 0; i < menuId.length; i++) {
			try {
				deleteMenu(Integer.valueOf(menuId[i]));
				deleteMenu.append(menuId[i]+"、");
				Struts2Utils.setAttribute("message","删除成功！");
			} catch (Exception e) {
				if(deleteMenu.length()>0){
					Struts2Utils.setAttribute("message", "已删除菜单id为："+deleteMenu+"的菜单,删除菜单id为"+menuId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
					 return 0;
				}else{
					Struts2Utils.setAttribute("message","还未删除菜单，在删除菜单id为"+menuId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
					return 0;
				}
			}
		}
		return 1;
	}


	@Override
	public void findByAllMenu() {
		List<Menu> allMenusList = menuDao.findByAllMenu();
		Struts2Utils.setAttribute("allMenusList", allMenusList);
	}
}
