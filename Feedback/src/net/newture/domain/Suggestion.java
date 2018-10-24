package net.newture.domain;

/**
 * Suggestion entity. @author MyEclipse Persistence Tools
 */

public class Suggestion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Long sugId;
	private User usersByTeacherId;
	private Feedback feedback;
	private User usersByStudentId;
	private String sugContent;

	// Constructors

	/** default constructor */
	public Suggestion() {
	}

	// Property accessors

	public Long getSugId() {
		return this.sugId;
	}

	public void setSugId(Long sugId) {
		this.sugId = sugId;
	}

	public User getUsersByTeacherId() {
		return this.usersByTeacherId;
	}

	public void setUsersByTeacherId(User usersByTeacherId) {
		this.usersByTeacherId = usersByTeacherId;
	}

	public Feedback getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public User getUsersByStudentId() {
		return this.usersByStudentId;
	}

	public void setUsersByStudentId(User usersByStudentId) {
		this.usersByStudentId = usersByStudentId;
	}

	public String getSugContent() {
		return this.sugContent;
	}

	public void setSugContent(String sugContent) {
		this.sugContent = sugContent;
	}

}