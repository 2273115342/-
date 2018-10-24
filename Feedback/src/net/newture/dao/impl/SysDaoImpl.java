package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.SysDao;
import net.newture.domain.FeedbackItem;
import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.DaoBase;

@Repository
public class SysDaoImpl extends DaoBase implements SysDao {

	@Override
	public List<Object[]> getSysMenuByRoleId(int roleId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select rl.role_id, ");
		sql.append("        rl.role_name, ");
		sql.append("        mn.menu_id, ");
		sql.append("        mn.parent_menu_id, ");
		sql.append("        mnp.menu_name as parent_menu_name, ");
		sql.append("        mn.menu_name, ");
		sql.append("        mn.url, ");
		sql.append("        mn.menu_desc ");
		sql.append("   from role rl, role_menu rm, menu mn, menu mnp ");
		sql.append("  where rm.role_id = rl.role_id ");
		sql.append("    and rm.menu_id = mn.menu_id ");
		sql.append("    and mn.parent_menu_id = mnp.menu_id(+) ");
		sql.append("    and mn.valid_flag = 1 ");
		sql.append("    and rm.role_id = ? ");
		sql.append("  order by mn.parent_menu_id, rm.disp_order ");
		
		return queryBySql(sql.toString(), new Object[]{roleId});
	}


	@Override
	public List<Class> findAllClasses() {
		return hibernateTemplate.find("from Class order by className");
	}

	@Override
	public List<Department> findAllDepartment() {
		return hibernateTemplate.find("from Department order by deptName");
	}@Override
	public List<Role> findAllRoles() {
		return hibernateTemplate.find("from Role order by roleName");
	}


	@Override
	public List<FeedbackItem> findAllFeedbackItems() {
		return hibernateTemplate.find("from FeedbackItem order by fiId");
	}


}
