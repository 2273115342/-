package net.newture.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.newture.dao.RoleMenuDao;
import net.newture.domain.Menu;
import net.newture.domain.Role;
import net.newture.framework.DaoBase;
@Repository
public class RoleMenuDaoImpl extends DaoBase implements RoleMenuDao {

	@Override
	public List<Object[]> save(Role role, Menu menu , Integer disporder) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into role_menu values(?,?,?)");
		return queryBySql(sql.toString(), new Object[] {role.getRoleId(),menu.getMenuId(),disporder});
	}

	@Override
	public List update(Role role, Menu menu , Integer disporder) {
		StringBuffer sql = new StringBuffer();
		sql.append("update from role_menu set role_id = ?");
		sql.append(",menu_id = ? ,disp_order = ? ");
		sql.append("  where role_id = ? and menu_id = ?");
		return queryBySql(sql.toString(), new Object[] {role.getRoleId(),menu.getMenuId(),disporder,role.getRoleId(),menu.getMenuId()});
	}

	@Override
	public List delete(Role role, Menu menu ) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from role_menu where role_id = ? and menu_id = ?");
		return queryBySql(sql.toString(), new Object[] {role.getRoleId(),menu.getMenuId()});
	}

	@Override
	public List findById(Integer rid, Integer mid) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from role_menu where role_id = ? and menu_id = ?");
		return queryBySql(sql.toString(), new Object[] {rid, mid});
	}

	@Override
	public List <Object[]> findAll() {
		String sql = "select * from role_menu";
		return queryBySql(sql.toString());
	}

	@Override
	public Role findByRoleName(Integer rid) {
		return hibernateTemplate.get(Role.class, rid);
	}

	@Override
	public Menu findByMenuName(Integer mid) {
		return hibernateTemplate.get(Menu.class, mid);
	}
}
