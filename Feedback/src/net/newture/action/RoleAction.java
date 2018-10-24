package net.newture.action;

import net.newture.domain.Role;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;

public class RoleAction extends ActionBase {
	private Role role;
	/** 操作类型：1新增 2修改 3删除 */
	private Integer operateType;

	@Autowired
	private RoleService roleService;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}


	/**
	 * 保存角色
	 * 
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (role.getRoleName() == null || role.getRoleName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "角色名不能为空！");
			return ERROR;
		}
		// 保存角色信息
		try {
			if (roleService.saveRole(role) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存角色信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存角色信息成功！");
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
			if (roleService.updateRole(role) != 1)
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
			roleService.deleteRole(role);
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
		roleService.findAllRole();
		return "list";
	}

}
