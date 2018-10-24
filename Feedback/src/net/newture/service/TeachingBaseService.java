package net.newture.service;

import net.newture.domain.TeachingBase;
import net.newture.domain.User;

public interface TeachingBaseService {
	
	/**
	 * 保存教学基地信息
	 * @param teachingBase 待保存教学基地
	 * @return 1：成功 -1：失败
	 */
	public int saveTeachingBase(TeachingBase teachingBase);

	/**
	 * 更新指定教学基地信息
	 * @param teachingBase 待更新教学基地
	 * @return 1：成功 -1：失败
	 */
	public int updateTeachingBase(TeachingBase teachingBase);

	/**
	 * 删除指定教学基地
	 * @param teachingBase 待删除教学基地
	 */
	public void deleteTeachingBase(TeachingBase teachingBase);
	
	/**
	 * 删除指定教学基地
	 * @param teachingBase 待删除教学基地
	 * @return 1：成功 -1：失败
	 */
	public int deleteTeachingBase(Integer id);
	
	/**
	 * 批量删除教学基地
	 * @param userId 批量删除教学基地id的集合
	 * @return success：成功    其他字符串：失败
	 */
	public String batchDeleteTeachingBase(String teachingBaseId[]);
	
	/**
	 * 查询制定编号的教学反馈信息
	 * @param id 需查询的教学编号
	 * @return
	 */
	public TeachingBase findTeachingBaseById(Integer id);

	/**
	 * 获取所有用户列表（只含有效用户）
	 */
	public void findAllTeachingBase();
	
	/**
	 * 根据查询条件获取用户信息<br/>
	 * 只获取一个用户信息。没有用户信息或有多个用户信息均视为异常。
	 * @param condName 查询条件字段名
	 * @param condValue 查询条件值
	 * @return
	 */
	public TeachingBase findByCond(String condName,String condValue);
}
