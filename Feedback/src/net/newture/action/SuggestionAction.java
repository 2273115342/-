package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Feedback;
import net.newture.domain.Suggestion;
import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.framework.util.WebUtil;
import net.newture.service.SuggestionService;
import net.newture.service.UserService;

public class SuggestionAction extends ActionBase {
	private Suggestion suggestion;
	private String condName;
	private String condValue;
	private long id;

	@Autowired
	private SuggestionService suggestionService;
	

	@Autowired
	private UserService userService;
	
	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
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

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 新增信息
	 * 
	 * @return
	 */
	public String add() {
		User user = (User)Struts2Utils.getSession().getAttribute("user");
		try {
			suggestionService.findByStudentId(user.getUserId());
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "查询班级授课老师信息出错:"+e);
		}
		return "add";
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String save() {
		Suggestion suggestion2 = new Suggestion();
		User user = (User)Struts2Utils.getSession().getAttribute("user");
		String suggestionText = Struts2Utils.getParameter("suggestionText");
		String teacherId = Struts2Utils.getParameter("usersByTeacherId");
		try {
			User teacher = userService.findUserById(Integer.valueOf(teacherId));
			User student = userService.findUserById(user.getUserId());
			suggestion2.setUsersByStudentId(student);
			suggestion2.setUsersByTeacherId(teacher);
			suggestion2.setSugContent(suggestionText);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "请确认你为学生");
			return "queryTeachers";
		}
		try {
			suggestionService.saveSuggestion(suggestion2);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存个人建议信息成功！");
		return "queryTeachers";
	}
	
	/**
	 * 查询个人建议
	 */
	public String query() {
		try {
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}

		return "query";
	}
	
	
	public String queryByCond() {
		try {
			System.out.println();
			System.out.println(condName+"  "+condValue);
			if ((condValue == null || condValue.trim().equals(""))&&((condName == null || condName.trim().equals("")))) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "query";
			}
			suggestionService.findByCond(condName,condValue );
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "query";
	}
	public String list() {
		suggestionService.findAllSuggestion();
		return "list";
	}
	
	
	
	/**
	 * 删除个人建议
	 */
	
	public String delete() {
		try {
			if (suggestionService.deleteSuggestion(id) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除个人建议出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除个人建议成功！");
		return SUCCESS;
	}
}
