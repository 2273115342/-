package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.FeedbackItemDao;
import net.newture.dao.SysDao;
import net.newture.domain.FeedbackItem;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemService;

@Service
public class FeedbackItemServiceImpl extends ServiceBase implements FeedbackItemService{
	
	@Autowired
	private FeedbackItemDao feedbackItemDao;
	@Autowired
	private SysDao sysDao;
	
		
	@Transactional
	public int saveFeedbackItem(FeedbackItem feedbackItem) {
		// 校验用户名是否存在
		FeedbackItem findFeedbackItem = feedbackItemDao.findByFiId(feedbackItem.getFiId());
		if (findFeedbackItem != null) {
			Struts2Utils.setAttribute("message1", "反馈指标项编号已经存在!");
			return -1;
		}
		// 保存
		this.feedbackItemDao.save(feedbackItem);
		return 1;
	}
	
	
	@Override
	public void getCodeTable() {
		// 获取反馈指标列表
		List<FeedbackItem> feedbackItems = sysDao.findAllFeedbackItems();
		Struts2Utils.setAttribute("feedbackItems", feedbackItems);
	}
	
	
	public FeedbackItem findFeedbackItemByfiId(Integer fiId) {
		return this.feedbackItemDao.findByFiId(fiId);
	}
	
	@Transactional
	public int updateFeedbackItem(FeedbackItem feedbackItem) {
		// 可进行必要的校验与处理
		// 例如密码，如果与原密码相同，说明用户没有修改，则不进行MD5加密；否则要进行加密处理
		// 更新用户信息
		this.feedbackItemDao.update(feedbackItem);
		return 1;
	}
	
	
	@Override
	@Transactional
	public int deleteFeedbackItem(Integer fiId) {
		// 根据主键编号查找用户对象
		FeedbackItem feedbackItem = feedbackItemDao.findByFiId(fiId);
		if (feedbackItem == null) {
			Struts2Utils.setAttribute("message", "删除反馈指标信息出错：找不到指定反馈指标！");
			return -1;
		} else {
			// 删除该对象
			feedbackItemDao.delete(feedbackItem);
			return 1;
		}
	}
	
	
	public void findAllFeedbackItem() {
		List<FeedbackItem> feedbackItems = this.feedbackItemDao.findAll();
		Struts2Utils.setAttribute("feedbackItems", feedbackItems);
	}
	
	
	public FeedbackItem findByCond(String condName,String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("fiId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("message", "查询反馈指标信息失败：输入的反馈指标编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<FeedbackItem> list = feedbackItemDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("message", "查询反馈指标信息失败：没有找到指定的反馈指标");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("message", "查询反馈指标信息失败：查找到多个反馈指标");
			return null;
		} else {
			return list.get(0);
		}
	}
	
	
	@Override
	public String batchDeleteFeedbackItem(String[] fiId) {
		StringBuffer deletedUser = new StringBuffer();
		int count = 0;
		if(fiId.length>0){
			//循环删除用户
			for (int i = 0; i < fiId.length; i++) {
				try{
					this.deleteFeedbackItem(Integer.valueOf(fiId[i]));
					count++;
					if(count%10==0)
						deletedUser.append(fiId[i]+"<br/>");
					else
						deletedUser.append(fiId[i]+"  ");
				}catch (Exception e) {
					if(deletedUser.length()>0){
						return "已删除id为："+deletedUser+"的用户,删除用户id为"+fiId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}else{
						return "还未删除用户，在删除用户id为"+fiId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}
				}
				
			}
		}else{
			return "所要删除的反馈指标为空";
		}
		return "success";
	}
}
