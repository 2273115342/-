package net.newture.service;

import net.newture.domain.Judge;

public interface JudgeService {

	/**
	 * 保存用户信息
	 * @param judge 待保存内容
	 * @return 1：成功 -1：失败
	 */
	public int savejudge(Judge judge);

	/**
	 * 更新指定用户信息
	 * @param judge 待更新用户
	 * @return 1：成功 -1：失败
	 */
	public int updatejudge(Judge judge);

	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 */
	
	public void deleteJudge(Judge judge);

	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 * @return 1：成功 -1：失败
	 */
	public int deleteJudge(Integer judgeId);

	/**
	 * 批量删除用户
	 * @param userId 批量删除用户id的集合
	 * @return success：成功    其他字符串：失败
	 */
	public String batchDeleteJudge(String judgeId[]);
	
	public Judge findJudgeById(Integer judgeId);

	/**
	 * 获取所有用户列表（只含有效用户）
	 * @return 
	 */
	public void findJudgeAll();

	public void getCodeTable();

	public Judge findByCond(Judge judge, String condvalue);

	public int saveJudge(Judge judge);

	public void findAllJudge();

	public int updateJudge(Judge judge);
	
}
