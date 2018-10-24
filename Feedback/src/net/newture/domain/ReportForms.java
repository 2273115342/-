package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 报表管理的实体类(为了简单所以不规范)
 * 属性不够用的时候自行添加
 * @author HJS22
 * 2018年6月30日23:48:01
 */
public class ReportForms implements java.io.Serializable {
	private static final long serialVersionUID = -5542572822329772384L;
	//以下为按班级统计所需的字段(可删减)
	private Integer feedbackId; //反馈id
	private String className; //class
	private Integer fiId; //评分项id
	private String fiName; //评分项
	private Double avgScore; //平均分
	private Integer fitId; //课程类型编号
	private String fitName; //课程类型名称
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getFiId() {
		return fiId;
	}
	public void setFiId(Integer fiId) {
		this.fiId = fiId;
	}
	public String getFiName() {
		return fiName;
	}
	public void setFiName(String fiName) {
		this.fiName = fiName;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	public Integer getFitId() {
		return fitId;
	}
	public void setFitId(Integer fitId) {
		this.fitId = fitId;
	}
	public String getFitName() {
		return fitName;
	}
	public void setFitName(String fitName) {
		this.fitName = fitName;
	}
	@Override
	public String toString() {
		return "ReportForms [feedbackId=" + feedbackId + ", className="
				+ className + ", fiId=" + fiId + ", fiName=" + fiName
				+ ", avgScore=" + avgScore + ", fitId=" + fitId + ", fitName="
				+ fitName + "]";
	}
}