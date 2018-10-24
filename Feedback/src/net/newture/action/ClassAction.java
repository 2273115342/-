package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ClassService;

public class ClassAction extends ActionBase {
	private Class classes;
	private Integer id;
	private String[] ids;
	private String condName;
	private String condValue;
	
	@Autowired
	private ClassService classService;
	
	
	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
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
	 * 添加班级
	 * 
	 * @return
	 */
	public String add() {
		try {
			classService.getClass();
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
	
	/**
	 * 保存信息
	 * 
	 * @return
	 */
	public String save() {
		try {
			classService.saveClass(classes);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存班级信息成功！");
		return "success";
	}
	
	/**
	 * 修改班级信息
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (classes == null) {
				if ((classes = classService.findClassById(id)) == null) {
					Struts2Utils.setAttribute("message", "修改班级信息初始化出错：找不到指定班级");
					return ERROR;
				}
			}
			classService.updateClass(classes);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"修改班级信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "edit";
	}
	
	/**
	 * 更新班级
	 * 
	 * @return
	 */
	public String update() {
		// 保存班级信息
		try {
			if (classService.updateClass(classes) != 1)
				return "updateCheckError";
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"更新班级信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新班级信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 删除班级
	 * 
	 * @return
	 */
	public String delete() {
		try {
			if (classService.deleteClass(id) != 1)
				return ERROR;
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"删除班级信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除班级信息成功！");
		return SUCCESS;
	}
	
	public String query (){
		return "query";
	}
	
	/**
	 * 查询班级
	 * 
	 * @return
	 */
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "queryCheckError";
			}
			classes = classService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (classes == null) {
			return ERROR;
		} else {
			return "query";
		}
}
}