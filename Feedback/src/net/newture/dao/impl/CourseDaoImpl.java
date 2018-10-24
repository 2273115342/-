package net.newture.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import net.newture.dao.CourseDao;
import net.newture.domain.Course;
import net.newture.framework.DaoBase;
@Repository
public class CourseDaoImpl extends DaoBase implements CourseDao{
	private Object condValue;
	public List<Course> findByCourse() {
		return hibernateTemplate.find("from Course");
	}
	public void save(Course course) {
		hibernateTemplate.save(course);		
	}
	public void update(Course course) {
		hibernateTemplate.update(course);		
	}
	public void delete(Course course) {
		hibernateTemplate.delete(course);
	}
	public Course findById(Integer id) {
		return hibernateTemplate.get(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		return hibernateTemplate.find("from course");
	}
	@Override
	public Course findByCourseName1(String courseName) {
		List list = hibernateTemplate.find("from course where courseName = ?", new Object[]{courseName});
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (Course)list.get(0);
		}
	}
	@Override
	public Course findByCourseName(String courseName) {
		/*Object [] objects = new Object[10];
		objects[0] =  courseName;*/
		List list = hibernateTemplate.find("from course where courseName = ?", new Object[]{courseName});
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (Course)list.get(0);
		}
	}
	@Override
	public List<Course> findByCond(Object condName, Object condValue) {
		String hql = "from Course where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}
	

}
