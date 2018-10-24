package net.newture.domain;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class RoleMenu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	
	private Integer rmId;
	private String roleName;
	private Integer roleId;
	private Integer menuId;
	private String menuName;
	private Integer dispOrder;
	private Integer parentMenuId;
	
	public Integer getRmId() {
		return rmId;
	}
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}
	public Integer getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
}