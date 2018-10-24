package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.framework.ActionBase;
import net.newture.service.CourseService;

public class FeedbackScoreAction extends ActionBase {

	private String content;
	private String request;
	private Integer point;

	@Autowired
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
}
