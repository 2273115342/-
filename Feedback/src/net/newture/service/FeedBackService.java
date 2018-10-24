package net.newture.service;


import java.util.List;

import net.newture.domain.Feedback;

public interface FeedBackService {
	
	public int openFeedBack(Feedback feedback);
	
	public int endFeedBack(Feedback feedback);
	
	public Feedback queryFeedBack (String condName,String condValue);
	
	public void findFeedBackAll();
	public int delete(Long id);
}
