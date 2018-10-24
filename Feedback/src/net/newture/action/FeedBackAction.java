package net.newture.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Feedback;
import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedBackService;
import net.newture.service.UserService;

public class FeedBackAction extends ActionBase{
	private Feedback feedback;
	private String condName;
	private String condValue;
	private Long id;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@Autowired
	private UserService userService;

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}

	public FeedBackService getFeedBackService() {
		return feedBackService;
	}

	public void setFeedBackService(FeedBackService feedBackService) {
		this.feedBackService = feedBackService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String begin(){
		try {
			if (feedBackService.openFeedBack(feedback) != 1)
				return "ERROR";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "成功开启反馈批次！");
		return SUCCESS;
	}
	
	public String end(){
		try {
			if (feedBackService.delete(id) != 1)
				return "ERROR";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "结束反馈批次！");
		return SUCCESS;
	}
	
	public String findAll(){
		feedBackService.findFeedBackAll();
		return "findAll";
	}
	
	public String query(){
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "ERROR";
			}
			feedback = feedBackService.queryFeedBack(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (feedback == null) {
			return ERROR;
		} else {
			return "queryList";
		}
	}
	
	public String queryList(){
		
		return "queryList";
	}
	
	public String beginList(){
		userService.getCodeTable();
		return "beginList";
	}
}
