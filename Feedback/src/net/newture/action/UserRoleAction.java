package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SysService;
import net.newture.service.UserRoleService;
import net.newture.service.UserService;

public class UserRoleAction extends ActionBase{
	private User user;
	/** 操作类型：1新增 2修改 3删除 */
	private Integer operateType;
	private String condName;
	private String condValue;
	private Integer id;
	
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * 修改用户
	 * 
	 * @return
	 */
	public String editList() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (user == null) {
				if ((user = userRoleService.findById(id)) == null) {
					Struts2Utils.setAttribute("message", "修改用户信息初始化出错：找不到指定用户");
					return ERROR;
				}
			}
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改用户信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "editList";
	}

	

	/**
	 * 更新用户
	 * 
	 * @return
	 */
	public String update() {
		System.out.println(id);
		try {
			if (userRoleService.updateUser(user) != 1)
				return "ERROR";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新用户角色信息成功！");
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (userRoleService.deleteRole(id) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除用户角色信息成功！");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	

	public String list() {
		userRoleService.findAllUser();
		return "list";
	}
	
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		try {
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}

		return "query";
	}
	
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "ERROR";
			}
			user = userService.findByCond(condName, condValue);
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (user == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
}
