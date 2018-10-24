package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.FeedbackItemTypeDao;
import net.newture.domain.FeedbackItemType;
import net.newture.framework.DaoBase;
@Repository
public class FeedbackItemTypeDaoImpl extends DaoBase implements FeedbackItemTypeDao {

	@Override
	public void save(FeedbackItemType feedbackItemType) {
		hibernateTemplate.save(feedbackItemType);
	}

	@Override
	public void update(FeedbackItemType feedbackItemType) {
		hibernateTemplate.update(feedbackItemType);
	}

	@Override
	public void delete(FeedbackItemType feedbackItemType) {
		hibernateTemplate.delete(feedbackItemType);
	}

	@Override
	public FeedbackItemType findById(Integer id) {
		return hibernateTemplate.get(FeedbackItemType.class, id); 
	}

	@Override
	public List<FeedbackItemType> findAll() {
		return hibernateTemplate.find("from FeedbackItemType");
	}

	@Override
	public FeedbackItemType findByName(String fitName) {
		List list = hibernateTemplate.find("from FeedbackItemType where fitName  = ?", fitName);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (FeedbackItemType)list.get(0);
		}
	}

	@Override
	public List<FeedbackItemType> findByCond(String condName, Object condValue) {
		String hql = "from FeedbackItemType where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}

}
