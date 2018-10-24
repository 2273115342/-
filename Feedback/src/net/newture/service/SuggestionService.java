package net.newture.service;

import net.newture.domain.Suggestion;



public interface SuggestionService {
	/**
	 * 保存个人建议信息
	 * @param user 待保存个人建议
	 * @return 1：成功 -1：失败
	 */
	public int saveSuggestion(Suggestion suggestion);
	/**
	 * 更新指定个人建议
	 * @param user 待更新个人建议
	 * @return 1：成功 -1：失败
	 */
	public int updateSuggestion(Suggestion suggestion);
	/**
	 * 删除指定个人建议
	 * @param teachingBase 待删除个人建议
	 * @return 1：成功 -1：失败
	 */
	public int deleteSuggestion(Long id);
	/**
	 * 查询制定编号的个人建议信息
	 * @param id 需查询的个人建议编号
	 * @return
	 */
	public Suggestion findSuggestionById(Long id);

	/**
	 * 获取所有个人建议列表（只含有效用户）
	 */
	public void findAllSuggestion();
	/**
	 * 根据查询条件获取用户信息<br/>
	 * 只获取一个用户信息。没有用户信息或有多个用户信息均视为异常。
	 * @param condName 查询条件字段名
	 * @param condValue 查询条件值
	 * @return
	 */
	public void findByCond(String condName,String condValue);
	
	/**
	 * 根据学生id查找班级信息
	 * @param studentId
	 */
	public void findByStudentId(Integer studentId);

}
