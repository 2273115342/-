package net.newture.dao;

import java.util.List;

import net.newture.domain.Judge;

public interface JudgeDao {
	/**
	 * 保存指定用户信息
	 * @param user 待保存用户
	 */
	public void save(Judge judge);

	/**
	 * 更新指定用户信息
	 * @param judge 待更新课程
	 */
	public void update(Judge judge);

	/**
	 * 删除指定用户
	 * @param judge 待删除课程
	 */
	public void delete(Judge judge);

	/**
	 * 根据主键编号查找评分
	 * @param id 主键编号
	 * @return
	 */
	public Judge findById(Integer id);
	
	/**
	 * 查询所有评分项
	 * @return
	 */
	public List<Judge> findAll();

	Judge findByjudgeId(String judgeId);

	

}
	

