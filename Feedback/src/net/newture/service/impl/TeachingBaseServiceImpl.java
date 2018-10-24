package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.TeachingBaseDao;
import net.newture.domain.TeachingBase;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.MD532;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.TeachingBaseService;
@Service
public class TeachingBaseServiceImpl extends ServiceBase implements
		TeachingBaseService {
	
	@Autowired
	private TeachingBaseDao teachingBaseDao;

	@Override
	public int saveTeachingBase(TeachingBase teachingBase) {
		teachingBaseDao.save(teachingBase);
		return 1;
	}

	@Override
	public int updateTeachingBase(TeachingBase teachingBase) {
		teachingBaseDao.update(teachingBase);
		return 1;
	}

	@Override
	public void deleteTeachingBase(TeachingBase teachingBase) {
		teachingBaseDao.delete(teachingBase);
		Struts2Utils.setAttribute("message", "删除用户信息成功！");
	}

	@Override
	public int deleteTeachingBase(Integer id) {
		TeachingBase teachingBase = teachingBaseDao.findById(id);
		if (teachingBase == null) {
			Struts2Utils.setAttribute("message", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			teachingBaseDao.delete(teachingBase);
			return 1;
		}
	}

	@Override
	public String batchDeleteTeachingBase(String[] teachingBaseId) {
		StringBuffer deletedUser = new StringBuffer();
		int count = 0;
		if(teachingBaseId.length>0){
			//循环删除用户
			for (int i = 0; i < teachingBaseId.length; i++) {
				try{
					this.deleteTeachingBase(Integer.valueOf(teachingBaseId[i]));
					count++;
					if(count%10==0)
						deletedUser.append(teachingBaseId[i]+"<br/>");
					else
						deletedUser.append(teachingBaseId[i]+"  ");
				}catch (Exception e) {
					if(deletedUser.length()>0){
						return "已删除id为："+deletedUser+"的用户,删除用户id为"+teachingBaseId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}else{
						return "还未删除用户，在删除用户id为"+teachingBaseId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}
				}
				
			}
		}else{
			return "所要删除的用户为空";
		}
		return "success";
	}

	@Override
	public TeachingBase findTeachingBaseById(Integer id) {
		return teachingBaseDao.findById(id);
	}

	@Override
	public void findAllTeachingBase() {
		List teachingBases = teachingBaseDao.findAll();
		Struts2Utils.setAttribute("teachingBases", teachingBases);
	}

	@Override
	public TeachingBase findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("baseId")) {
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
		List<TeachingBase> list = teachingBaseDao.findByCond(condName, condValueObj);
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

}
