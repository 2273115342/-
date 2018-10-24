package net.newture.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.jws.soap.SOAPBinding.Style;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;
import net.newture.framework.ActionBase;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.MenuService;
import net.newture.service.RoleService;

public class MenuAction extends ActionBase {
	private static final long serialVersionUID = -6783277745553495746L;
	
	private Menu menu;

	private RoleMenu rolemenu;
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public RoleMenu getRolemenu() {
		return rolemenu;
	}

	public void setRolemenu(RoleMenu rolemenu) {
		this.rolemenu = rolemenu;
	}

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 文件上传所需
	 */
	private File menuIcon;  //用户上传的文件
	private String menuIconFileName; //上传文件的文件名
	private String menuIconContentType; //上传文件的类型
	
	public File getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(File menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	public String getMenuIconFileName() {
		return menuIconFileName;
	}

	public void setMenuIconFileName(String menuIconFileName) {
		this.menuIconFileName = menuIconFileName;
	}

	public String getMenuIconContentType() {
		return menuIconContentType;
	}

	public void setMenuIconContentType(String menuIconContentType) {
		this.menuIconContentType = menuIconContentType;
	}

	/**
	 * @Title: add   
	 * @Description: TODO(新增菜单)     
	 * @return String   返回类型
	 */
	public String add() {
		if(menuIcon!=null){
			ServiceBase serviceBase = new ServiceBase();
			if(serviceBase.updateFile(menuIcon, menuIconFileName, "MenuImg"))
				return "success";
			else
				//处理菜单图片路径
				menu.setMenuIcon("upload/MenuImg/"+this.getMenuIconFileName());
		}
		try {
			if(menuService.saveMenu(menu)!=1)
				Struts2Utils.setAttribute("success", "-1");
			else
				Struts2Utils.setAttribute("success", "1");
			
		} catch (Exception e) {
			Struts2Utils.setAttribute("success", "-1");
			Struts2Utils.setAttribute("message",
					"新增菜单失败：" + (e.getMessage() != null ? e.getMessage()
							: "")
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
		}

		return "success";
	}
	
	/**
	 * @Title: updateMenu   
	 * @Description: TODO(更改系统菜单)     
	 * @return String   返回类型
	 */
	public String updateMenu(){
		if(menuIcon!=null){
			ServiceBase serviceBase = new ServiceBase();
			if(serviceBase.updateFile(menuIcon, menuIconFileName, "MenuImg"))
				return "update";
			else
				//处理菜单图片路径
				menu.setMenuIcon("upload/MenuImg/"+this.getMenuIconFileName());
		}else{
			menu.setMenuIcon(Struts2Utils.getParameter("menuIconOld"));
		}
		try {
			menuService.updateMenu(menu);
			Struts2Utils.setAttribute("updateMessage","修改成功！");
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改菜单失败：" + (e.getMessage() != null ? e.getMessage()
							: "")
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			e.printStackTrace();
		}
		return "update";
	}
	
	/**
	 * @Title: alertMenu   
	 * @Description: TODO(进入修改菜单页面)     
	 * @return String   返回类型
	 */
	public String alertMenu(){
		try {
			String menuId = Struts2Utils.getParameter("menuId");
			menuService.findByMenuId(Integer.valueOf(menuId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(Struts2Utils.getParameter("lookMenu")!=null){
			Struts2Utils.setAttribute("lookMenu", "1");
		}
		return "alertMenu";
	}
	/**
	 * @Title: deleteMenu   
	 * @Description: TODO(删除系统菜单)     
	 * @return String   返回类型
	 */
	public String deleteMenu(){
		String menuId = Struts2Utils.getParameter("menuId");
		try {
			menuService.deleteMenu(Integer.valueOf(menuId));
			Struts2Utils.setAttribute("message","删除成功！");
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除菜单失败：" + (e.getMessage() != null ? e.getMessage()
							: "")
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
		}
		return "update";
	}
	
	public String batchDeleteMenu(){
		String menuId[] = Struts2Utils.getParameterValues("ids");
		try {
			menuService.batchDeleteMenu(menuId);
		} catch (Exception e) {
			
		}
		return "update";
	}
	
	/**
	 * @Title: lookMenuByCondition   
	 * @Description: TODO(根据搜索条件查询)     
	 * @return String   返回类型
	 */
	public String lookMenuByCondition(){
		String searchText = Struts2Utils.getParameter("searchText");
		if(searchText==null||searchText.length()<=0){
			Struts2Utils.setAttribute("lookMenu", 1);
			return "lookMenuByCondition";
		}
		try {
			menuService.findByMenuId(Integer.valueOf(Integer.valueOf(searchText)));
		} catch (Exception e) {
			try {
				menuService.fineByMenuName(searchText);
				Struts2Utils.setAttribute("message", "查询成功！");
			} catch (Exception e2) {
				Struts2Utils.setAttribute("message",
						"查询菜单失败：" + (e.getMessage() != null ? e.getMessage()
								: "")
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: ""));
			}
		}
		Struts2Utils.setAttribute("NoPage", "1");  //标识为从搜索跳转的，不要分页功能
		return "looMenu";
	}
	
	/**
	 * @Title: menuManage   
	 * @Description: TODO(查询系统菜单)     
	 * @return String   返回类型
	 */
	public String menuManage(){
		try {
			String page = Struts2Utils.getParameter("page");
			int pageCount = 0;
			if(page!=null){  //如果page存在则查询指定的页数  否则查询第一页的
				pageCount = Integer.valueOf(page.toString());
			}
			menuService.findAllMenu(pageCount,5);
		} catch (Exception e) {
			e.printStackTrace();
			Struts2Utils.setAttribute("message",
					"查询菜单失败：" + (e.getMessage() != null ? e.getMessage()
							: "")
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
		}
		if(Struts2Utils.getParameter("lookMenu")!=null||Struts2Utils.getAttribute("lookMenu")!=null){  //如果不为null 则为查看界面提交过来的
			Struts2Utils.setAttribute("message", "查询成功！");
			return "looMenu";
		} 
		return "menuManage";
	}
	
	/**
	 * 
	 * @Title: findFirstMenu   
	 * @Description: TODO(查询首级菜单)     
	 * @return String   返回类型
	 */
	public String findFirstMenu(){
		List<Object[]> list = menuService.findFirstMenu();
		return "add";
	}
	
	/**
	 * @Title: roleMenuManage   
	 * @Description: TODO(进入角色菜单维护界面)     
	 * @return String   返回类型
	 */
	public String roleMenuManage(){
		try {
			roleService.findAllRole();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "执行出错了"+e);
		}
		if(Struts2Utils.getParameter("st")!=null||Struts2Utils.getAttribute("st")!=null){  //标识从查询页面跳转过来的
			Struts2Utils.setAttribute("st", "1");
		}
		return "queryRoleMenu";
	}
	
	/**
	 * @Title: queryRoleMenue   
	 * @Description: TODO(根据角色id查询角色的菜单信息)     
	 * @return String   返回类型
	 */
	public String queryRoleMenu(){
		try {
			menuService.findByAllMenu(); //查询所有的系统菜单
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "查询所有的系统菜单失败:"+e);
		}
		try {
			menuService.findByRoleId(Integer.valueOf(Struts2Utils.getParameter("roleId")));
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "查询角色已拥有菜单失败:"+e);
		}
		Struts2Utils.setAttribute("roleName", Struts2Utils.getParameter("roleName"));
		Struts2Utils.setAttribute("roleId", Struts2Utils.getParameter("roleId"));
		if(Struts2Utils.getParameter("st")!=null){ //看是否是从查询页面跳转过来的
			Struts2Utils.setAttribute("st", 1);
		};
		return "queryAlertRoleMenu";
	}
	
	/**
	 * @Title: alertRoleMenue   
	 * @Description: TODO(修改角色菜单信息)     
	 * @return String   返回类型
	 */
	public String alertRoleMenu(){
		try {
			String addMenuId[] = Struts2Utils.getParameterValues("addMenuId"); //获得要添加的菜单信息
			String deleteMenuId[] = Struts2Utils.getParameterValues("deleteMenuId"); //获得要删除的菜单id
			String rmId[] = Struts2Utils.getParameterValues("roleMenuId"); //获得要删除的角色菜单id
			String rid = Struts2Utils.getParameter("roleId"); //获得要操作的角色id
			if(addMenuId != null && addMenuId.length>0  && rid != null && rid.trim().length() > 0) 
				menuService.batchIncreaseRoleMenu(addMenuId,  Integer.valueOf(rid));
			if(deleteMenuId != null && deleteMenuId.length > 0 && rmId != null && rmId.length>0 && rid.trim().length() > 0) 
				menuService.batchDeletionRoleMenu(deleteMenuId, rmId, Integer.valueOf(rid));
			Struts2Utils.setAttribute("message", "操作成功!");
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", e);
		}
		return "alertRoleMenue";
	}
}
