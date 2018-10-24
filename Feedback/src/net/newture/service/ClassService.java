package net.newture.service;

import net.newture.domain.TeachingBase;

public interface ClassService {
	/**
	 * 保存班级信息
	 * @param class 待保存班级信息
	 * @return 1：成功 -1：失败
	 */
	public int saveClass(Class classes);
	
	/**
	 * 更新指定班级信息
	 * @param teachingBase 待更新班级信息
	 * @return 1：成功 -1：失败
	 */
	public int updateClass(Class classes);
	
	/**
	 * 查询指定编号的班级信息
	 * @param id 需查询的班级信息
	 * @return
	 */
	public Class findClassById(Integer id);
	
	/**
	 * 删除指定班级信息
	 * @param teachingBase 待删除班级信息
	 */
	public int deleteClass(Integer id);
	
	/**
	 * 批量删除班级信息
	 * @param userId 批量删除班级
	 * @return success：成功    其他字符串：失败
	 */
	public String batchDeleteClass(String classesId[]);
	
	/**
	 * 获取所有用户列表（只含有效用户）
	 */
	public void findAllclass();
	
	/**
	 * 查询班级
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public Class findByCond(String className, String classValue);	
	
}
