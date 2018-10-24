package net.newture.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.newture.framework.DaoBase;

public class TestDaoBase {
	@Test
	@Transactional
	public void testGetSingleResult1() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select idcard from User where userId = 1";
		System.out.println(daoBase.getSingleResult(hql));
	}

	@Test
	@Transactional
	public void testGetSingleResult2() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName='admin' and password='E10ADC3949BA59ABBE56E057F20F883E'";
		assertEquals(1, ((Long) daoBase.getSingleResult(hql)).intValue());
	}

	@Test
	@Transactional
	public void testGetSingleResult3() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName=?";
		assertEquals(1, ((Long) daoBase.getSingleResult(hql, "luohl")).intValue());
	}

	@Test
	@Transactional
	public void testGetSingleResult4() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName=? and password=?";
		assertEquals(1,
				((Long) daoBase.getSingleResult(hql, new Object[] { "admin", "E10ADC3949BA59ABBE56E057F20F883E" }))
						.intValue());
	}

	@Test
	@Transactional
	public void testQueryBySql1() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);

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
		sql.append("    and rm.role_id = 1 ");
		sql.append("  order by mn.parent_menu_id, rm.disp_order ");

		List list = daoBase.queryBySql(sql.toString());
		// 循环输出结果
		for (int i = 0; i < list.size(); i++) { // 循环输出集合中的对象
			Object[] obj = (Object[]) list.get(i);// 将输出对象放入数组中
			// 循环输出数组中的元素
			for (int j = 0; j < obj.length; j++) {
				System.out.print(obj[j] + "  ");
			}
			System.out.println();
		}
	}
	
	@Test
	@Transactional
	public void testQueryBySql2() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);

		String sql = "select * from users where user_id >= ? and login_name like ?";
		List list = daoBase.queryBySql(sql, new Object[]{2, "%n%"});
		// 循环输出结果
		for (int i = 0; i < list.size(); i++) { // 循环输出集合中的对象
			Object[] obj = (Object[]) list.get(i);// 将输出对象放入数组中
			// 循环输出数组中的元素
			for (int j = 0; j < obj.length; j++) {
				System.out.print(obj[j] + "  ");
			}
			System.out.println();
		}
	}
}

@Repository
class DaoBaseTester extends DaoBase {

}
