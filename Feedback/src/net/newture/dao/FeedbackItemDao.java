package net.newture.dao;

import java.util.List;

import net.newture.domain.FeedbackItem;
import net.newture.domain.User;

public interface FeedbackItemDao {
		
	/**
	 * 保存指定用户信息
	 * @param user 待保存用户
	 */
	public void save(FeedbackItem feedbackItem);
	
	/**
	 * 根据反馈指标项编号查找反馈指标项信息
	 * @param fiId 反馈指标项编号
	 * @return FeedbackItem对象
	 */
	public FeedbackItem findByFiId(Integer fiId);
	
	/**
	 * 更新指定反馈指标信息
	 * @param feedbackItem 待更新反馈指标
	 */
	public void update(FeedbackItem feedbackItem);
	
	/**
	 * 删除指定反馈指标信息
	 * @param feedbackItem 待删除反馈指标
	 */
	public void delete(FeedbackItem feedbackItem);
	
	/**
	 * 查询所有反馈指标列表
	 * @return
	 */
	public List<FeedbackItem> findAll();
	
	
	/**
	 * 根据条件进行查找
	 * @param condName 查询条件字段名称
	 * @param condValue 查询条件值
	 * @return
	 */
	public List<FeedbackItem> findByCond(String condName,Object condValue);
}
