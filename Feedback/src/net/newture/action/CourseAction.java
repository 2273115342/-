package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Course;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.CourseService;

public class CourseAction extends ActionBase{
	private Course course;
	private Integer Id;
	private String condName;
	private String condValue;
	public String getCondValue() {
		return condValue;
	}
	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}



	private String[] ids;

	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCoursenName() {
		return condName;
	}
	public void setCoursenName(String coursenName) {
		this.condName = coursenName;
	}



	@Autowired
	CourseService courseService;

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	
	public String list() {
		courseService.findCourseAll();
		return "list";
	}

	
	
	/**
	 * @Title: add   
	 * @Description: TODO(进入添加课程的页面)     
	 * @return String   返回类型
	 */
	public String add() {
		
		return "add";
	}
	
	/**
	 * 保存课程
	 * 
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1)
		return "saveCheckError";
		// 保存课程信息
		try {
			if(courseService.saveCourse(course) !=1) return "saveCheckError";
			
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存用户信息成功！");
		return SUCCESS;
	}
	

	/**
	 * 更新课程
	 * 
	 * @return
	 */
	public String update() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "updateCheckError";
		// 保存用户信息
		try {
			if (courseService.updateCourse(course) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新课程信息成功！");
		return SUCCESS;
	}

	
	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 * 
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (course.getCourseName() == null || course.getCourseName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "用户名不能为空！");
			return -1;
		}
		return 1;
	}


	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (courseService.deleteCourse(Id) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除用户信息成功！");
		return SUCCESS;
	}
	
	/**
	* @Title: listDelete   
	* @Description: TODO(批量删除用户)     
	* @return String    返回类型   
	*/
	public String batchDelete(){
	String state = null;
		state = courseService.batchDeleteCourse(ids);
		if(state.indexOf("删除")==-1){
			Struts2Utils.setAttribute("message", "批量删除用户信息成功！已删除id为："+state+"的用户");
			return SUCCESS;
		}
		Struts2Utils.setAttribute("message",state);
		return ERROR;
		
	}
	
	/**
	 * 修改课程
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (course == null) {
				if ((course = courseService.findCourseById(Id)) == null) {
					Struts2Utils.setAttribute("message", "修改用户信息初始化出错：找不到指定用户");
					return ERROR;
				}
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改用户信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "edit";
	}
	
	
	
	/**
	 * @Title: alertRoleMenue   
	 * @Description: TODO(修改课程信息)     
	 * @return String   返回类型
	 */
	public String alertCourse(){
		int flag = courseService.updateCourse(course);
		if(flag==1){
			Struts2Utils.setAttribute("message", "修改成功");
			return "alertCourse";
		}else{
			Struts2Utils.setAttribute("message", "修改失败");
			return "alertCourse";
		}
	}
	public String addCourse(){
		if(courseService.saveCourse(course)==1){
			Struts2Utils.setAttribute("message", "新增成功");
			return "alertCourse";
		}else{
			Struts2Utils.setAttribute("message", "新增失败");
			return "alertCourse";
		}
		
	}
	
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		try {
			courseService.getCodeTable();
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
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "queryCheckError";
			}
			course = courseService.findByCond(condName, condValue);
			courseService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询课程信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (course == null) {
			return ERROR;
		} else {
			return "query";
		}
	}

}
