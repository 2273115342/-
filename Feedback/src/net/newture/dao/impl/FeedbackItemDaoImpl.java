package net.newture.dao.impl;

import java.util.List;

import net.newture.dao.FeedbackItemDao;
import net.newture.domain.FeedbackItem;
import net.newture.domain.User;
import net.newture.framework.DaoBase;

import org.springframework.stereotype.Repository;

@Repository
public class FeedbackItemDaoImpl extends DaoBase implements FeedbackItemDao {
	
	public void save(FeedbackItem feedbackItem) {
		hibernateTemplate.save(feedbackItem);
	}
	
	public void update(FeedbackItem feedbackItem) {
		hibernateTemplate.update(feedbackItem);
	}
	
	public void delete(FeedbackItem feedbackItem) {
		hibernateTemplate.delete(feedbackItem);
	}
	
	
	public List<FeedbackItem> findByCond(String condName,Object condValue) {
		String hql = "from FeedbackItem where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}
	
	@Override
	public FeedbackItem findByFiId(Integer fiId) {
		List list = hibernateTemplate.find("from FeedbackItem where fiId = ?", fiId);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (FeedbackItem)list.get(0);
		}
	}
	
	public List<FeedbackItem> findAll() {
		return hibernateTemplate.find("from FeedbackItem  order by fiId");
	}
}
