package net.newture.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import net.newture.dao.MenuDao;
import net.newture.domain.Menu;
import net.newture.domain.RoleMenu;
import net.newture.framework.DaoBase;

/**
 * 用一句话来描述这个类的作用
 * @author js
 *  2018年6月23日 下午4:32:37
 */
@Repository
public class MenuDaoImpl extends DaoBase implements MenuDao {

	@Override
	public List MenuCount() {
		return queryBySql("select count(*) from menu");
	}
	
	@Override
	public void save(Menu menu) {
		hibernateTemplate.save(menu);
	}
	
	@Override
	public List findAllMenu(Object object,Integer offset,Integer length) {
		return getListForPage(object, offset, length);
	}
	
	
	@Override
	public List<Object[]> findFirstMenu() {
		String hql = "select * from menu where parent_menu_id=0";
		return queryBySql(hql);
	}

	@Override
	public List<Object[]> findByRoleIdNo(Object [] objects ) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select  ");
		sql.append(" r.role_name, ");
		sql.append(" rm.role_id, ");
		sql.append(" m.menu_id, ");
		sql.append(" m.menu_name, ");
		sql.append(" rm.disp_order, ");
		sql.append(" rm.rm_id, ");
		sql.append(" m.parent_menu_id ");
		sql.append(" from menu m,role_menu rm,role r  ");
		sql.append(" where  ");
		sql.append(" m.menu_id=rm.rm_id(+) ");
		sql.append(" and r.role_id(+) = rm.role_id   ");
		sql.append(" and m.menu_id not in ");
		sql.append(" (select rm.menu_id  ");
		sql.append(" from role_menu rm,role r  ");
		sql.append(" where r.role_id=rm.role_id  ");
		sql.append(" and rm.role_id = ?) ");
		sql.append(" order by rm.role_id ");
		return queryBySql(sql.toString(),objects);
	}

	@Override
	public List<Object[]> findByRoleId(Object[] objects) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select r.role_name, ");
		sql.append(" rm.role_id, ");
		sql.append(" rm.menu_id, ");
		sql.append(" m.menu_name, ");
		sql.append(" rm.disp_order, ");
		sql.append(" rm.rm_id, ");
		sql.append(" m.parent_menu_id ");
		sql.append(" from role_menu rm,menu m,role r  ");
		sql.append(" where r.role_id=rm.role_id  ");
		sql.append(" and rm.menu_id=m.menu_id  ");
		sql.append(" and rm.role_id=? ");
		return queryBySql(sql.toString(),objects);
	}
	
	@Override
	public List<Object[]> findAllRoleMenu() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select  r.role_name,rm.role_id, ");
		sql.append(" rm.menu_id,m.menu_name, ");
		sql.append(" rm.disp_order,rm.rm_id  ");
		sql.append(" from menu m,role_menu rm,role r  ");
		sql.append(" where m.menu_id=rm.rm_id  ");
		sql.append(" and r.role_id = rm.role_id  ");
		sql.append(" order by rm.role_id ");
		return queryBySql(sql.toString());
	}

	@Override
	public void updateRoleMenu(RoleMenu roleMenu) {
		this.hibernateTemplate.update(roleMenu);
	}

	@Override
	public void saveRoleMenu(RoleMenu roleMenu) {
		this.hibernateTemplate.save(roleMenu);
	}

	@Override
	public void deleteRoleMenu(RoleMenu roleMenu) {
		this.hibernateTemplate.delete(roleMenu);
	}

	@Override
	public List<Object[]> findByRoleMenuId(Integer roleMenuId) {
		String sql = "select * from role_menu where rm_id = ?";
		return queryBySql(sql,new Object[]{roleMenuId});
	}

	@Override
	public List findByMenuId(Integer menuId) {
		String sql = "select menu_id,menu_name,url,menu_icon,parent_menu_id,valid_flag,menu_desc from menu where menu_id = ?";
		return queryBySql(sql,new Object[]{menuId});
	}
	
	@Override
	public List fineByMenuName(String menuName) {
		String sql = "select menu_id,menu_name,url,menu_icon,parent_menu_id,valid_flag,menu_desc from menu where menu_name like ?";
		return queryBySql(sql,new Object[]{"%"+menuName+"%"});
	}

	@Override
	public void update(Menu menu) {
		hibernateTemplate.update(menu);
	}

	@Override
	public void delete(Menu menu) {
		hibernateTemplate.delete(menu);
	}

	@Override
	public List findByAllMenu() {
		return hibernateTemplate.find("from Menu");
	}
}
