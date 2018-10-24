package net.newture.domain;

import java.util.Date;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer userId;
	private Department department;
	private Role role;
	private Class classes;
	private String loginName;
	private String password;
	private String name;
	private String idcard;
	private String sex;
	private Date birthday;
	private String address;
	private String telephone;
	private Byte status = 1;
	private Byte userType;
	
	

	// Constructors



	/** default constructor */
	public User() {
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Class getClasses() {
		return this.classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getUserType() {
		return this.userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}
}