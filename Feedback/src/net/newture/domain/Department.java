package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer deptId;
	private String deptName;
	private String deptAddress;
	private Set<User> userses = new HashSet<User>();

	// Constructors

	/** default constructor */
	public Department() {
	}

	// Property accessors

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAddress() {
		return this.deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public Set<User> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<User> userses) {
		this.userses = userses;
	}

}