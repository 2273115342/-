package net.newture.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.newture.dao.impl.UserDaoImpl;
import net.newture.domain.Role;
import net.newture.domain.User;

public class TestUserDaoImpl {
	@Test
	public void testFindByLoginName() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDaoImpl userDao = applicationContext.getBean("userDaoImpl", UserDaoImpl.class);
		User user = userDao.findByLoginName("admin");
	}
	
	@Test
	public void testFindAll() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDaoImpl userDao = applicationContext.getBean("userDaoImpl", UserDaoImpl.class);
		List<User> users = userDao.findAll();
		Role role = users.get(0).getRole();
	}
	
	@Test
	public void testFindById() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDaoImpl userDao = applicationContext.getBean("userDaoImpl", UserDaoImpl.class);
		Integer i = 23;
		User user = userDao.findById(i);
	}
}
