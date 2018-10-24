package net.newture.service;

import net.newture.domain.FeedbackItemType;

public interface FeedbackItemTypeService {
	
	/**
	 * 保存教学基地信息
	 * @param teachingBase 待保存教学基地
	 * @return 1：成功 -1：失败
	 */
	public int saveFeedbackItemType(FeedbackItemType feedbackItemType);

	/**
	 * 更新指定教学基地信息
	 * @param teachingBase 待更新教学基地
	 * @return 1：成功 -1：失败
	 */
	public int updateFeedbackItemType(FeedbackItemType feedbackItemType);

	/**
	 * 删除指定教学基地
	 * @param teachingBase 待删除教学基地
	 */
	public void deleteFeedbackItemType(FeedbackItemType feedbackItemType);
	
	/**
	 * 删除指定教学基地
	 * @param teachingBase 待删除教学基地
	 * @return 1：成功 -1：失败
	 */
	public int deleteFeedbackItemType(Integer id);
	
	/**
	 * 批量删除教学基地
	 * @param userId 批量删除教学基地id的集合
	 * @return success：成功    其他字符串：失败
	 */
	public String batchDeleteFeedbackItemType(String feedbackItemType[]);
	
	/**
	 * 查询制定编号的教学反馈信息
	 * @param id 需查询的教学编号
	 * @return
	 */
	public FeedbackItemType findFeedbackItemTypeById(Integer id);

	/**
	 * 获取所有用户列表（只含有效用户）
	 */
	public void findAllFeedbackItemType();
	
	/**
	 * 根据查询条件获取用户信息<br/>
	 * 只获取一个用户信息。没有用户信息或有多个用户信息均视为异常。
	 * @param condName 查询条件字段名
	 * @param condValue 查询条件值
	 * @return
	 */
	public FeedbackItemType findByCond(String condName,String condValue);
}
