package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.RoleMenuDao;
import net.newture.domain.Menu;
import net.newture.domain.Role;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleMenuService;
@Service
public class RoleMenuServiceImpl extends ServiceBase implements RoleMenuService {
	@Autowired
	RoleMenuDao roleMenuDao;
	
	@Transactional
	public int saveRoleMenu(Role role, Menu menu ,Integer disporder) {
		List list = roleMenuDao.save(role, menu, disporder);
		for(Object i : list) {
			if (!i.equals(1)) {
				return 0;
			}
		}
		return 1;
	}

	@Transactional
	public int updateRoleMenu(Role role , Menu menu ,Integer disporder) {
		List list = roleMenuDao.update(role, menu, disporder);
		for(Object i : list) {
			if (!i.equals(1)) {
				return 0;
			}
		}
		roleMenuDao.findByRoleName(role.getRoleId());
		roleMenuDao.findByMenuName(menu.getMenuId());
		return 1;
	}

	@Transactional
	public void deleteRoleMenu(Role role , Menu menu ) {
		List list = roleMenuDao.delete(role, menu);
		for(Object i : list) {
			if (!i.equals(1)) {
				System.out.println("删除失败");
			}
		}
		System.out.println("删除成功");
	}

	@Transactional
	public int deleteRoleMenu(Integer rid, Integer mid) {
		List list = roleMenuDao.findById(rid, mid);
		for(Object i : list) {
			if (!i.equals(1)) {
				return 0;
			}
		}
		return 1;
	}

	@Transactional
	public void findAllRoleMenu() {
		List<Object[]> roleMenus = roleMenuDao.findAll();
		int roleID = 0 , menuID = 0, disporder = 0;
		StringBuffer rolemenu = new StringBuffer();
		
		for(int i = 0; i<roleMenus.size(); i++){
			Object[] roleMenu = (Object[]) roleMenus.get(i);
			roleID = Integer.valueOf(roleMenu[0].toString());
			menuID = Integer.valueOf(roleMenu[1].toString());
			disporder = Integer.valueOf(roleMenu[2].toString());
			Role role = roleMenuDao.findByRoleName(roleID);
			Menu menu = roleMenuDao.findByMenuName(menuID);
			rolemenu.append("<tr class='vieworder_row'>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append("<input type='checkbox' name='ids' value=" +roleID + " />");
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append(roleID);
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append("<input type='text' name='role.roleName_" + roleID + "' id='role.roleName_" + roleID +"' value=" + role.getRoleName() + "  disabled='true' />");
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append( menuID);
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append("<input type='text' name='menu.menuName_" + menuID + "' id='menu.menuName_" + menuID + "' value=" + menu.getMenuName() + " disabled='true' />");
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append("<input type='text' name='disporder_" + roleID +"' id='disporder_" + roleID +"' value=" + disporder  +  " disabled='true' />");
			rolemenu.append("</td>");
			rolemenu.append("<td  align='center'>");
			rolemenu.append("<input type='button' onclick='editSingle(" + roleID + "," + menuID +"," + disporder +  ")' value=' 修 改 ' /> ");
			rolemenu.append("<input type='button' onclick='delSingle(" + roleID + "," + menuID + ")' value=' 删 除' /> ");
			rolemenu.append("</td>");
			rolemenu.append("</tr>");
			rolemenu.append("\r\n");
		}
		Struts2Utils.setAttribute("roleMenus", roleMenus);
		Struts2Utils.setAttribute("rolemenu", rolemenu.toString());
	}
}
