package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer roleId;
	private String roleName;
	private Set<User> userses = new HashSet<User>();

	// Constructors

	/** default constructor */
	public Role() {
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Set<User> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<User> users) {
		this.userses = users;
	}
}