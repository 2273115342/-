package net.newture.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Department;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.DepartmentService;

public class DepartmentAction extends ActionBase{
	private Department department;
	private Integer id;
	@Autowired
	private DepartmentService departmentService;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 新增部门
	 *
	 * @return
	 */
	public String add() {
		return "add";
	}
	
	/**
	 * 保存部门
	 *
	 * @return
	 */
	public String save() {
		try {
			if(departmentService.savedepartment(department)!=1){
				return "updateCheckError";
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"保存部门信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存部门信息成功！");
		return SUCCESS;
	}
	
	
	/**
	 * 遍历部门信息
	 * @return
	 */
	public String manage() {
		departmentService.getPartmentTable();
		return "manage";
	}
	
	/**
	 * 删除部门
	 *
	 * @return
	 */
	public String delete() {
		try {
			departmentService.deleteDepartment(department);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "删除部门信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除部门信息成功！");
		return SUCCESS;
	}
	
	// 批量删除用户
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				departmentService.deleteDepartment(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "删除部门信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "删除角色部门信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 更新部门
	 *
	 * @return
	 */
	public String update() {
		// 保存部门信息
		try {
			if (departmentService.updateDepartment(department) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("message", "更新部门信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "更新部门信息成功！");
		return SUCCESS;
	}

}
