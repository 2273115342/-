package net.newture.domain;

import java.util.Date;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer classId;
	private TeachingBase teachingBase;
	private User counselor;
	private String className;
	private Date createDate;
	private Byte status;

	// Constructors

	/** default constructor */
	public Class() {
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public TeachingBase getTeachingBase() {
		return this.teachingBase;
	}

	public void setTeachingBase(TeachingBase teachingBase) {
		this.teachingBase = teachingBase;
	}

	public User getUsers() {
		return this.counselor;
	}

	public void setUsers(User user) {
		this.counselor = user;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}