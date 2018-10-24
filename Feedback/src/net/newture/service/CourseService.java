package net.newture.service;

import java.util.List;

import net.newture.domain.Course;

public interface CourseService {
	/**
	 * 保存用户信息
	 * @param user 待保存用户
	 * @return 1：成功 -1：失败
	 */
	public int saveCourse(Course course);

	/**
	 * 更新指定用户信息
	 * @param user 待更新用户
	 * @return 1：成功 -1：失败
	 */
	public int updateCourse(Course course);

	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 */
	public void deleteCourse(Course course);
	
	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 * @return 1：成功 -1：失败
	 */
	public int deleteCourse(Integer id);

	/**
	 * 批量删除用户
	 * @param userId 批量删除用户id的集合
	 * @return success：成功    其他字符串：失败
	 */
	public String batchDeleteCourse(String courseId[]);
	
	public Course findCourseById(Integer id);

	/**
	 * 获取所有用户列表（只含有效用户）
	 * @return 
	 */
	public void findCourseAll();

	public void getCodeTable();

	public Course findByCond(String coursenName, String condvalue);

	
	
}
