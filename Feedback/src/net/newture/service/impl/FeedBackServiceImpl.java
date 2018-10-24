package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.FeedBackDao;
import net.newture.domain.Feedback;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedBackService;
@Service
public class FeedBackServiceImpl extends ServiceBase implements FeedBackService{

	@Autowired
	FeedBackDao feedBackDao;
	@Override
	public int openFeedBack(Feedback feedback) {
		feedBackDao.openFeedBack(feedback);
		return 1;
	}

	@Override
	public int endFeedBack(Feedback feedback) {
		feedBackDao.endFeedBack(feedback);
		return 1;
	}
	
	@Override
	@Transactional
	public int delete(Long id) {
		// 根据主键编号查找用户对象
		Feedback feedback = feedBackDao.findById(id);
		if (feedback == null) {
			return -1;
		} else {
			// 删除该对象
			feedBackDao.endFeedBack(feedback);
			return 1;
		}
	}

	@Override
	public Feedback queryFeedBack(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("feedbackId")) {
			Long i;
			try {
				i = Long.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("message", "查询批次信息失败：输入的批次编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<Feedback> list = feedBackDao.queryFeedBack(condName, condValue);
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

	@Override
	public void findFeedBackAll() {
		List<Feedback> feedbackAlls = feedBackDao.findAll();
		Struts2Utils.setAttribute("feedbackAlls", feedbackAlls);
	}
	
}
