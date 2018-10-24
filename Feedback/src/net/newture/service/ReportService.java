package net.newture.service;


import net.newture.domain.Class;
import net.newture.domain.ClassCourse;
import net.newture.domain.FeedbackItemType;
import net.newture.domain.FeedbackScore;
import net.newture.domain.User;

public interface ReportService {

	public void teacher(User user);
	
	public void classes(ClassCourse classCourse);
	
	public void indexItems(FeedbackItemType feedbackItemType);
	
	public void baseAvgScore(FeedbackScore feedbackScore);
}
