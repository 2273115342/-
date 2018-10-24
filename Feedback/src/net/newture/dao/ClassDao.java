package net.newture.dao;

import java.util.List;

import net.newture.domain.Class;

public interface ClassDao {
	/**
	 * 保存指定班级信息
	 * @param user 待保存班级
	 */
	public void save(Class classes);

	/**
	 * 更新指定教学基地信息
	 * @param user 待更新教学基地
	 */
	public void update(Class classes);

	/**
	 * 删除指定教学基地
	 * @param user 待删除教学基地
	 */
	public void delete(Class classes);

	/**
	 * 根据主键编号查找教学基地
	 * @param id 主键编号
	 * @return
	 */
	public Class findById(Integer id);
	
	/**
	 * 查询所有教学基地列表
	 * @return
	 */
	public List<Class> findAll();
	
	/**
	 * 查询指定的教学基地名次存在不存在
	 * @param teachingBaseName 待查询的教学基名称
	 * @return TeachingBase对象
	 */
	public Class findByTeachingBaseName(String teachingBaseName);
	
	/**
	 * 根据条件进行查找
	 * @param condName 查询条件字段名称
	 * @param condValue 查询条件值
	 * @return
	 */
	public List<Class> findByCond(String condName,Object condValue);
}
