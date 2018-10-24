package net.newture.domain;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer menuId;
	private String menuName;
	private String url;
	private String menuIcon;
	private Integer parentMenuId;
	private Integer validFlag;
	private String menuDesc;
	private Short dispOrder;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getParentMenuId() {
		return this.parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public Short getDispOrder() {
		return this.dispOrder;
	}

	public void setDispOrder(Short dispOrder) {
		this.dispOrder = dispOrder;
	}

}