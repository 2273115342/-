package net.newture.domain;

/**
 * ClassCourse entity. @author MyEclipse Persistence Tools
 */

public class ClassCourse implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	private Long ccId;
	private User teacher;
	private Class classes;
	private Course course;
	private Short schoolYear;
	private Byte semester;

	// Constructors

	/** default constructor */
	public ClassCourse() {
	}

	// Property accessors

	public Long getCcId() {
		return this.ccId;
	}

	public void setCcId(Long ccId) {
		this.ccId = ccId;
	}

	public User getUsers() {
		return this.teacher;
	}

	public void setUsers(User user) {
		this.teacher = user;
	}

	public Class getClasses() {
		return this.classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Short getSchoolYear() {
		return this.schoolYear;
	}

	public void setSchoolYear(Short schoolYear) {
		this.schoolYear = schoolYear;
	}

	public Byte getSemester() {
		return this.semester;
	}

	public void setSemester(Byte semester) {
		this.semester = semester;
	}

}