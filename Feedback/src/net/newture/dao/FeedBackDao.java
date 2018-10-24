package net.newture.dao;

import java.util.List;

import net.newture.domain.Feedback;

public interface FeedBackDao {
	
	public void openFeedBack(Feedback feedback);
	
	public void endFeedBack(Feedback feedback);
	
	public List<Feedback> queryFeedBack (String condName,String condValue);
	
	public List<Feedback> findAll();
	public Feedback findById(Long id);
}
