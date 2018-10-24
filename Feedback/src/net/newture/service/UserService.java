package net.newture.service;

import net.newture.domain.User;

public interface UserService {
	/**
	 * 保存用户信息
	 * @param user 待保存用户
	 * @return 1：成功 -1：失败
	 */
	public int saveUser(User user);

	/**
	 * 更新指定用户信息
	 * @param user 待更新用户
	 * @return 1：成功 -1：失败
	 */
	public int updateUser(User user);

	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 */
	public void deleteUser(User user);
	
	/**
	 * 删除指定用户
	 * @param user 待删除用户
	 * @return 1：成功 -1：失败
	 */
	public int deleteUser(Integer id);

	/**
	 * 批量删除用户
	 * @param userId 批量删除用户id的集合
	 * @return success：成功    其他字符串：失败
	 */
	public int batchDeleteUser(String userId[]);
	
	public User findUserById(Integer id);

	/**
	 * 获取所有用户列表（只含有效用户）
	 */
	public void findAllUser();
	
	/**
	 * 根据查询条件获取用户信息<br/>
	 * 只获取一个用户信息。没有用户信息或有多个用户信息均视为异常。
	 * @param condName 查询条件字段名
	 * @param condValue 查询条件值
	 * @return
	 */
	public User findByCond(String condName,String condValue);
	
	/**
	 * 验证登录用户是否合法
	 * @param user 待验证用户信息
	 * @return boolean
	 */
	public boolean isValidLoginUser(User user);
	
	/**
	 * 获取用户代码表信息（如角色列表、部门列表等）
	 */
	public void getCodeTable();
}
