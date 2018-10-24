package net.newture.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Long feedbackId;
	private Class classes;
	private String feedbackName;
	private Short schoolYear;
	private Boolean semester;
	private Byte times;
	private Date beginTiime;
	private Date endTime;
	private Byte status;
	private String remark;
	private Set<FeedbackScore> feedbackScores = new HashSet<FeedbackScore>();
	private Set<Suggestion> suggestions = new HashSet<Suggestion>();

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	// Property accessors

	public Long getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Class getClasses() {
		return this.classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public String getFeedbackName() {
		return this.feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public Short getSchoolYear() {
		return this.schoolYear;
	}

	public void setSchoolYear(Short schoolYear) {
		this.schoolYear = schoolYear;
	}

	public Boolean getSemester() {
		return this.semester;
	}

	public void setSemester(Boolean semester) {
		this.semester = semester;
	}

	public Byte getTimes() {
		return this.times;
	}

	public void setTimes(Byte times) {
		this.times = times;
	}

	public Date getBeginTiime() {
		return this.beginTiime;
	}

	public void setBeginTiime(Date beginTiime) {
		this.beginTiime = beginTiime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<FeedbackScore> getFeedbackScores() {
		return this.feedbackScores;
	}

	public void setFeedbackScores(Set<FeedbackScore> feedbackScores) {
		this.feedbackScores = feedbackScores;
	}

	public Set<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(Set<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

}