package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.SysDao;
import net.newture.dao.UserDao;
import net.newture.domain.Menu;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SysService;

@Service
public class SysServiceImpl extends ServiceBase implements SysService {
	@Autowired
	private SysDao sysDao;

	public void getLoginUserMenuInfo() {
		// 获取登录用户信息
		User loginUser = getLoginUser();
		List<Object[]> menus = sysDao.getSysMenuByRoleId(loginUser.getRole().getRoleId());
		int parentMenuId,menuId;
		String menuName, menuUrl;
		List<Menu> userMenuList = new ArrayList<Menu>();
		for (int i = 0; i < menus.size(); i++) {
			Object[] menu = (Object[]) menus.get(i);
			Menu menu2 = new Menu();
				// 获取菜单信息
				parentMenuId = Integer.parseInt(menu[3].toString());
				menuName = menu[5].toString();
				menuId = Integer.valueOf(menu[2].toString());
				//如果上级菜单等于0 则不添加url
				if(parentMenuId!=0){
					menuUrl = menu[6].toString();
					menu2.setUrl(menuUrl);
				}
				menu2.setMenuId(menuId);
				menu2.setParentMenuId(parentMenuId);
				menu2.setMenuName(menuName);
				userMenuList.add(menu2);
				
		}
		Struts2Utils.setAttribute("userMenuList", userMenuList);
	}

}
