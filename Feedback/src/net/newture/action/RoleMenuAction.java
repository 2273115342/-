package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Menu;
import net.newture.domain.Role;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleMenuService;

public class RoleMenuAction extends ActionBase {
	private Role role;
	private Menu menu;
	private Integer disporder;
	/** 操作类型：1新增 2修改 3删除 */
	private Integer operateType;

	@Autowired
	private RoleMenuService roleMenuService;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public Integer getDisporder() {
		return disporder;
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setDisporder(Integer disporder) {
		this.disporder = disporder;
	}


	public String save () {
		// 校验必录信息项
		if (role.getRoleName() == null || role.getRoleName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "角色名不能为空！");
			return ERROR;
		}
		if (menu.getMenuName() == null || menu.getMenuName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "菜单名不能为空！");
			return ERROR;
		}
		// 保存角色信息
		try {
			if (roleMenuService.saveRoleMenu(role, menu, disporder)!= 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存角色信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存角色菜单信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 更新角色
	 * 
	 * @return
	 */
	public String update() {
		// 校验必录信息项
		if (role.getRoleName() == null || role.getRoleName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "角色名不能为空！");
			return ERROR;
		}
		// 保存角色信息
		try {
			if (roleMenuService.updateRoleMenu(role, menu, disporder) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新角色信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新角色信息成功！");
		return SUCCESS;
	}

	/**
	 * 删除角色
	 * 
	 * @return
	 */
	public String delete() {
		try {
			roleMenuService.deleteRoleMenu(role, menu);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除角色信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除角色信息成功！");
		return SUCCESS;
	}


	public String list() {
//		roleMenuService.findAllRoleMenu();
		return "list";
	}
}
