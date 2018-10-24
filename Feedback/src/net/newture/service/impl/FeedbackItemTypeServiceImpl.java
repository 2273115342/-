package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.FeedbackItemTypeDao;
import net.newture.domain.FeedbackItemType;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemTypeService;
@Service
public class FeedbackItemTypeServiceImpl extends ServiceBase implements
		FeedbackItemTypeService {
	
	@Autowired
	private FeedbackItemTypeDao feedbackItemTypeDao;

	@Override
	public int saveFeedbackItemType(FeedbackItemType feedbackItemType) {
		feedbackItemTypeDao.save(feedbackItemType);;
		return 1;
	}

	@Override
	public int updateFeedbackItemType(FeedbackItemType feedbackItemType) {
		feedbackItemTypeDao.update(feedbackItemType);;
		return 1;
	}

	@Override
	public void deleteFeedbackItemType(FeedbackItemType feedbackItemType) {
		feedbackItemTypeDao.delete(feedbackItemType);;
		Struts2Utils.setAttribute("message", "删除信息成功！");
	}

	@Override
	public int deleteFeedbackItemType(Integer id) {
		FeedbackItemType feedbackItemType = feedbackItemTypeDao.findById(id);
		if (feedbackItemType == null) {
			Struts2Utils.setAttribute("message", "删除信息出错：找不到指定信息");
			return -1;
		} else {
			// 删除该对象
			feedbackItemTypeDao.delete(feedbackItemType);;
			return 1;
		}
	}

	@Override
	public String batchDeleteFeedbackItemType(String feedbackItemType[]) {
		StringBuffer deletedUser = new StringBuffer();
		int count = 0;
		if(feedbackItemType.length>0){
			//循环删除用户
			for (int i = 0; i < feedbackItemType.length; i++) {
				try{
					this.deleteFeedbackItemType(Integer.valueOf(feedbackItemType[i]));
					count++;
					if(count%10==0)
						deletedUser.append(feedbackItemType[i]+"<br/>");
					else
						deletedUser.append(feedbackItemType[i]+"  ");
				}catch (Exception e) {
					if(deletedUser.length()>0){
						return "已删除反馈类别,删除id为"+feedbackItemType[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}else{
						return "还未删除信息，在删除id为"+feedbackItemType[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}
				}
				
			}
		}else{
			return "所要删除的信息为空";
		}
		return "success";
	}

	@Override
	public FeedbackItemType findFeedbackItemTypeById(Integer id) {
		return feedbackItemTypeDao.findById(id);
	}

	@Override
	public void findAllFeedbackItemType() {
		List feedbackItemTypes = feedbackItemTypeDao.findAll();
		Struts2Utils.setAttribute("feedbackItemTypes", feedbackItemTypes);
	}

	@Override
	public FeedbackItemType findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("fitId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("message", "查询信息失败：输入的编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<FeedbackItemType> list = feedbackItemTypeDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("message", "查询信息失败：没有找到指定的信息");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("message", "查询信息失败：查找到多个信息");
			return null;
		} else {
			return list.get(0);
		}
	}

}
