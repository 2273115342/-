package net.newture.domain;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer courseId;
	private String courseName;
	private Byte courseType;

	// Constructors

	/** default constructor */
	public Course() {
	}

	// Property accessors

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Byte getCourseType() {
		return this.courseType;
	}

	public void setCourseType(Byte courseType) {
		this.courseType = courseType;
	}

}