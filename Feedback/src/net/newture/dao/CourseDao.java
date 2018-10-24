package net.newture.dao;

import java.util.List;

import net.newture.domain.Course;
import net.newture.domain.User;


public interface CourseDao {
	/**
	 * 保存指定用户信息
	 * @param user 待保存用户
	 */
	public void save(Course course);

	/**
	 * 更新指定用户信息
	 * @param course 待更新课程
	 */
	public void update(Course course);

	/**
	 * 删除指定用户
	 * @param course 待删除课程
	 */
	public void delete(Course course);

	/**
	 * 根据主键编号查找课程
	 * @param id 主键编号
	 * @return
	 */
	public Course findById(Integer id);
	
	/**
	 * 根据课程名查找用户信息
	 * @param courseName 课程名
	 * @return Course对象
	 */
	public Course findByCourseName(String courseName);
	
	
	
	
	public List<Course> findByCourse();
	
	/**
	 * 查询所有课程列表
	 * @return
	 */
	public List<Course> findAll();

	Course findByCourseName1(String courseName);

	/**
	 * 根据条件查询
	 * @param condName 查询条件字段名称
	 * @param condValue 查询条件值
	 * @return
	 */
	public List<Course> findByCond(Object condName, Object condValue);

	

}
	

