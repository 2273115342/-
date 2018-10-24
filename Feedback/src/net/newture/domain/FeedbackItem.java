package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * FeedbackItem entity. @author MyEclipse Persistence Tools
 */

public class FeedbackItem implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer fiId;
	private FeedbackItemType feedbackItemType;
	private String fiName;
	private Short itemValue;
	private Short dispOrder;

	// Constructors

	/** default constructor */
	public FeedbackItem() {
	}


	// Property accessors

	public Integer getFiId() {
		return this.fiId;
	}

	public void setFiId(Integer fiId) {
		this.fiId = fiId;
	}

	public FeedbackItemType getFeedbackItemType() {
		return this.feedbackItemType;
	}

	public void setFeedbackItemType(FeedbackItemType feedbackItemType) {
		this.feedbackItemType = feedbackItemType;
	}

	public String getFiName() {
		return this.fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public Short getItemValue() {
		return this.itemValue;
	}

	public void setItemValue(Short itemValue) {
		this.itemValue = itemValue;
	}

	public Short getDispOrder() {
		return this.dispOrder;
	}

	public void setDispOrder(Short dispOrder) {
		this.dispOrder = dispOrder;
	}

}