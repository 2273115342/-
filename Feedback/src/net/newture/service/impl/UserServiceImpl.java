package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.SysDao;
import net.newture.dao.UserDao;
import net.newture.domain.Department;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.MD532;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserService;

@Service
public class UserServiceImpl extends ServiceBase implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SysDao sysDao;

	@Transactional
	public int saveUser(User user) {
		// 校验用户名是否存在
		User findUser = userDao.findByLoginName(user.getLoginName());
		if (findUser != null) {
			Struts2Utils.setAttribute("message1", "用户名已经被注册!");
			return -1;
		}
		//把用户输入的密码用MD5加密
		user.setPassword(new MD532().getMD5(user.getPassword()));
		// 保存
		this.userDao.save(user);
		return 1;
	}

	@Transactional
	public int updateUser(User user) {
		// 可进行必要的校验与处理
		// 例如密码，如果与原密码相同，说明用户没有修改，则不进行MD5加密；否则要进行加密处理
		// 更新用户信息
		this.userDao.update(user);
		return 1;
	}

	@Transactional
	public void deleteUser(User user) {
		this.userDao.delete(user);
		Struts2Utils.setAttribute("message", "删除用户信息成功！");
	}
	
	@Override
	@Transactional
	public int deleteUser(Integer id) {
		// 根据主键编号查找用户对象
		User user = userDao.findById(id);
		if (user == null) {
			Struts2Utils.setAttribute("message", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			userDao.delete(user);
			return 1;
		}
	}

	@Override
	public int batchDeleteUser(String[] userId) {
		StringBuffer deletedUser = new StringBuffer();
		int count = 0;
		if(userId.length>0){
			//循环删除用户
			for (int i = 0; i < userId.length; i++) {
				try{
					this.deleteUser(Integer.valueOf(userId[i]));
					count++;
					if(count%10==0) deletedUser.append(userId[i]+"<br/>");
					else deletedUser.append(userId[i]+"、");
				}catch (Exception e) {
					if(deletedUser.length()>0){
						Struts2Utils.setAttribute("message", "已删除id为："+deletedUser+"的用户,删除用户id为"+userId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: ""));
						 return 0;
					}else{
						Struts2Utils.setAttribute("message","还未删除用户，在删除用户id为"+userId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: ""));
						return 0;
					}
				}
			}
		}else{
			return 0;
		}
		return 1;
	}
	
	public User findUserById(Integer id) {
		return this.userDao.findById(id);
	}
	
	public User findByCond(String condName,String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("userId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("message", "查询用户信息失败：输入的用户编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<User> list = userDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("message", "查询用户信息失败：没有找到指定的用户");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("message", "查询用户信息失败：查找到多个用户");
			return null;
		} else {
			return list.get(0);
		}
	}

	public void findAllUser() {
		List<User> users = this.userDao.findAll();
		Struts2Utils.setAttribute("users", users);
	}

	@Override
	public boolean isValidLoginUser(User user) {
		String loginName = user.getLoginName().trim();
		String pwd = user.getPassword();
		if (!loginName.equals("") && !pwd.equals("")) {
			// 密码进行MD5加密
			pwd = new MD532().getMD5(user.getPassword());
			int count = userDao.countByLoginNameAndPwd(loginName, pwd);
			if (count == 1) {
				Struts2Utils.getSession().setAttribute("user", userDao.findByLoginName(loginName));
				return true;
			}
			Struts2Utils.setAttribute("message", "用户名或密码有误!");
			return false;
		} else {
			Struts2Utils.setAttribute("message", "用户名与密码不能为空!");
			return false;
		}
	}

	@Override
	public void getCodeTable() {
		// 获取用户角色列表
		List<Role> roles = sysDao.findAllRoles();
		Struts2Utils.setAttribute("roles", roles);
		// 获取班级列表
		List<Class> classes = sysDao.findAllClasses();
		Struts2Utils.setAttribute("classes", classes);
		// 获取部门列表
		List<Department> departments = sysDao.findAllDepartment();
		Struts2Utils.setAttribute("departments", departments);
		
	}

}
