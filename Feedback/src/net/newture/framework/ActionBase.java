package net.newture.framework;

import com.opensymphony.xwork2.ActionSupport;

import net.newture.framework.util.Struts2Utils;

public class ActionBase extends ActionSupport {
	/**
	 * 判断系统是否已经登录
	 * @return boolean
	 */
	public boolean isLogined() {
		return Struts2Utils.getSession().getAttribute("user") != null;
	}
}
