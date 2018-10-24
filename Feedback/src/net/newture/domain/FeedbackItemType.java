package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * FeedbackItemType entity. @author MyEclipse Persistence Tools
 */

public class FeedbackItemType implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer fitId;
	private String fitName;
	private Set<FeedbackItem> feedbackItems = new HashSet<FeedbackItem>();

	// Constructors

	/** default constructor */
	public FeedbackItemType() {
	}
	
	// Property accessors

	public Integer getFitId() {
		return this.fitId;
	}

	public void setFitId(Integer fitId) {
		this.fitId = fitId;
	}

	public String getFitName() {
		return this.fitName;
	}

	public void setFitName(String fitName) {
		this.fitName = fitName;
	}

	public Set<FeedbackItem> getFeedbackItems() {
		return this.feedbackItems;
	}

	public void setFeedbackItems(Set<FeedbackItem> feedbackItems) {
		this.feedbackItems = feedbackItems;
	}

}