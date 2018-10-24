package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.framework.ActionBase;
import net.newture.service.SysService;

public class IndexAction extends ActionBase {
	@Autowired
	private SysService sysService;
	
	/**
	 * 主页信息
	 * @return
	 */
	public String getIndexInfo() {
		return SUCCESS;
	}
	
	/**
	 * 获取系统菜单
	 * @return
	 */
	public String getSysMenu() {
		sysService.getLoginUserMenuInfo();
		return SUCCESS;
	}
}
