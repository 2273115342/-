package net.newture.domain;

import java.math.BigDecimal;

/**
 * FeedbackScore entity. @author MyEclipse Persistence Tools
 */

public class FeedbackScore implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Long fsId;
	private User teacher;
	private Feedback feedback;
	private Course course;
	private User student;
	private FeedbackItem feedbackItem;
	private BigDecimal score;

	// Constructors

	/** default constructor */
	public FeedbackScore() {
	}
	
	// Property accessors

	public Long getFsId() {
		return this.fsId;
	}

	public void setFsId(Long fsId) {
		this.fsId = fsId;
	}

	public User getTeacher() {
		return this.teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Feedback getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getStudent() {
		return this.student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public FeedbackItem getFeedbackItem() {
		return this.feedbackItem;
	}

	public void setFeedbackItem(FeedbackItem feedbackItem) {
		this.feedbackItem = feedbackItem;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}