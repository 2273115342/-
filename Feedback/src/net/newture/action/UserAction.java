package net.newture.action;

import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserAction extends ActionBase {
	private User user;
	private Integer id;
	private String condName;
	private String condValue;
	private String[] ids; //批量删除用户的id集合   别改我代码Thanks
	
	@Autowired
	private UserService userService;

	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * 新增用户
	 * 
	 * @return
	 */
	public String add() {
		try {
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}

		return "add";
	}
	//
	
	
	
	//

	/**
	 * 修改用户
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (user == null) {
				if ((user = userService.findUserById(id)) == null) {
					Struts2Utils.setAttribute("message", "修改用户信息初始化出错：找不到指定用户");
					return ERROR;
				}
			}
			userService.getCodeTable();
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
	 * 保存用户
	 * 
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "saveCheckError";
		// 保存用户信息
		try {
			if (userService.saveUser(user) != 1)
				return "saveCheckError";
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
	 * 更新用户
	 * 
	 * @return
	 */
	public String update() {
		// 校验必录信息项
		if (checkFormInput() != 1)
			return "updateCheckError";
		// 保存用户信息
		try {
			if (userService.updateUser(user) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新用户信息成功！");
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (userService.deleteUser(id) != 1)
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
		if(userService.batchDeleteUser(ids)!=0){
			Struts2Utils.setAttribute("message", "批量删除用户信息成功!");
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 * 
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (user.getLoginName() == null || user.getLoginName().trim().equals("")) {
			Struts2Utils.setAttribute("message1", "用户名不能为空！");
			return -1;
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			Struts2Utils.setAttribute("message2", "密码不能为空!");
			return -1;
		}
		return 1;
	}

	public String list() {
		userService.findAllUser();
		return "list";
	}

	/**
	 * 系统登录
	 * 
	 * @return
	 */
	public String login() {
		if (isLogined()) {
			return "logined";
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 用户登录校验
	 * 
	 * @return
	 */
	public String loginCheck() {
		String code = Struts2Utils.getParameter("code") == null ? "" : Struts2Utils.getParameter("code");
		String rand = (String) Struts2Utils.getSession().getAttribute("rand");
		if (user.getLoginName() == null || user.getLoginName().trim().equals("")) {
			Struts2Utils.setAttribute("message", "用户名不能为空！");
			return ERROR;
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			Struts2Utils.setAttribute("message", "密码不能为空!");
			return ERROR;
		}
		if (code.equals(rand)) {
			if (userService.isValidLoginUser(user)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			Struts2Utils.setAttribute("message", "验证码有误!");
			return ERROR;
		}
	}
	
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		try {
			userService.getCodeTable();
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
			user = userService.findByCond(condName, condValue);
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (user == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
	/**
	 * @Title: quitLogin   
	 * @Description: TODO(用户退出登录)     
	 * @return String   返回类型
	 */
	public String quitLogin(){
		Struts2Utils.getSession().removeAttribute("user");
		return "login";
	}
}
