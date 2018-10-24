package net.newture.service;

import net.newture.domain.FeedbackItem;
import net.newture.domain.User;

public interface FeedbackItemService {
		/**
		 * 保存信息
		 * @param fi 待保存
		 * @return 1：成功 -1：失败
		 */
		public int saveFeedbackItem(FeedbackItem feedbackItem);
		
		/**
		 * 获取用户代码表信息（如角色列表、部门列表等）
		 */
		public void getCodeTable();
		
		public FeedbackItem findFeedbackItemByfiId(Integer fiId);
		
		/**
		 * 更新指定反馈指标信息
		 * @param feedbackItem 待更新反馈指标
		 * @return 1：成功 -1：失败
		 */
		public int updateFeedbackItem(FeedbackItem feedbackItem);
		
		/**
		 * 删除指定反馈指标
		 * @param feedbackItem 待删除反馈指标
		 */
		public int deleteFeedbackItem(Integer fiId);
		
		/**
		 * 获取所有反馈指标列表（只含有效反馈指标）
		 */
		public void findAllFeedbackItem();
		
		/**
		 * 根据查询条件获取反馈指标信息<br/>
		 * 只获取一个反馈指标信息。没有反馈指标信息或有多个反馈指标信息均视为异常。
		 * @param condName 查询条件字段名
		 * @param condValue 查询条件值
		 * @return
		 */
		public FeedbackItem findByCond(String condName,String condValue);
		
		
		/**
		 * 批量删除反馈指标
		 * @param fiId 批量删除反馈指标id的集合
		 * @return success：成功    其他字符串：失败
		 */
		public String batchDeleteFeedbackItem(String fiId[]);
}
