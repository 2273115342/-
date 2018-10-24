package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.dao.TeachingBaseDao;
import net.newture.domain.TeachingBase;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.TeachingBaseService;

public class TeachingBaseAction extends ActionBase{
	private TeachingBase teachingBase;
	private Integer id;
	private String[] ids; //批量删除用户的id集合
	private String condName;
	private String condValue;
	
	@Autowired 
	TeachingBaseService teachingBaseService;
	
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

	public TeachingBase getTeachingBase() {
		return teachingBase;
	}

	public void setTeachingBase(TeachingBase teachingBase) {
		this.teachingBase = teachingBase;
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

	public TeachingBaseService getTeachingBaseService() {
		return teachingBaseService;
	}

	public void setTeachingBaseService(TeachingBaseService teachingBaseService) {
		this.teachingBaseService = teachingBaseService;
	}

	/**
	 * 新增教学基地页面打开
	 * 
	 * @return
	 */
	public String add() {
		return "add";
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String save() {
		try {
			teachingBaseService.saveTeachingBase(teachingBase);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("message", "保存教学基地信息成功！");
		return "success";
	}

	/**
	 * 修改教学基地
	 * 
	 * @return
	 */
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (teachingBase == null) {
				if ((teachingBase = teachingBaseService.findTeachingBaseById(id)) == null) {
					Struts2Utils.setAttribute("message", "修改用户信息初始化出错：找不到指定用户");
					return ERROR;
				}
			}
			teachingBaseService.updateTeachingBase(teachingBase);
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
	 * 更新用户
	 * 
	 * @return
	 */
	public String update() {
		// 保存用户信息
		try {
			if (teachingBaseService.updateTeachingBase(teachingBase) != 1)
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
			if (teachingBaseService.deleteTeachingBase(id) != 1)
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
		state = teachingBaseService.batchDeleteTeachingBase(ids);
		if(state.equals("success")){
			Struts2Utils.setAttribute("message", "批量删除用户信息成功！");
			return SUCCESS;
		}
		System.out.println(state);
		Struts2Utils.setAttribute("message",state);
		return ERROR;
		
	}

	public String list() {
		teachingBaseService.findAllTeachingBase();
		return "list";
	}
	
	public String query (){
		return "query";
	}
	
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("message", "必须输入查询条件值！");
				return "queryCheckError";
			}
			teachingBase = teachingBaseService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("message",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (teachingBase == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
}
