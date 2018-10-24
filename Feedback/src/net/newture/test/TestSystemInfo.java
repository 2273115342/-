package net.newture.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.service.impl.SysServiceImpl;

public class TestSystemInfo {
	@Test
	@Transactional
	public void testProcessIndexInfo() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		SysServiceImpl sysServiceImpl = applicationContext.getBean("sysServiceImpl", SysServiceImpl.class);
		User user = new User();
		Role role = new Role();
		role.setRoleId(1);
		user.setRole(role);
		// 该代码只在测试时使用
//		sysServiceImpl.getMenuInfoByRoleId(user);
	}
}
