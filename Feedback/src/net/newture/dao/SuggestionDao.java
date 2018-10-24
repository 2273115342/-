package net.newture.dao;

import java.util.List;

import net.newture.domain.Suggestion;
import net.newture.domain.TeachingBase;



public interface SuggestionDao {
	/**
	 * 保存指定个人建议信息
	 * @param user 待保存个人建议
	 */
	public void save(Suggestion suggestion);
	/**
	 * 更新指定个人建议信息
	 * @param user 待更新个人建议
	 */
	public void update(Suggestion suggestion);
	/**
	 * 删除指定个人建议信息
	 * @param user 待删除个人建议
	 */
	public void delete(Suggestion suggestion);
	/**
	 * 根据主键编号查找个人建议
	 * @param id 主键编号
	 * @return
	 */
	public Suggestion findById(Long id);
	/**
	 * 查询所有个人建议列表
	 * @return
	 */
	public List<Suggestion> findAll();
	/**
	 * 根据教师id查询
	 * @param teacherId 输入的教师id
	 * @return
	 */
	public List findByTeacherId(Integer teacherId);
	/**
	 * 根据学生id查询班级授课老师信息
	 * @param studentId
	 * @return
	 */
	public List<Object[]> findByStudentId(Integer studentId);
	
}
