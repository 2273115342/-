package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.FeedBackDao;
import net.newture.domain.Feedback;
import net.newture.domain.User;
import net.newture.framework.DaoBase;
@Repository
public class FeedBackDaoImpl extends DaoBase implements FeedBackDao {

	@Override
	public void openFeedBack(Feedback feedback) {
		hibernateTemplate.save(feedback);
	}

	@Override
	public void endFeedBack(Feedback feedback) {
		hibernateTemplate.delete(feedback);
	}

	@Override
	public List<Feedback> queryFeedBack(String condName, String condValue) {
		String hql = "from Feedback where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}

	@Override
	public List<Feedback> findAll() {
		return hibernateTemplate.find("from Feedback where status = 2");
	}
	
	public Feedback findById(Long id) {
		return hibernateTemplate.get(Feedback.class, id);
	}

}
