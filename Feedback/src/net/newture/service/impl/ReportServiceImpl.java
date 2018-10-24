package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.ReportDao;
import net.newture.domain.ClassCourse;
import net.newture.domain.FeedbackItemType;
import net.newture.domain.FeedbackScore;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportService;
@Service
public class ReportServiceImpl extends ServiceBase implements ReportService {

	@Autowired
	ReportDao reportDao;
	@Override
	public void teacher(User user) {
		List<Object[]> teachers = reportDao.teacher(user.getUserId());
		StringBuffer teacher =  new StringBuffer();
		String className, feedBackName, semester = null, teacherName = null, courseName = null,
		fitName = null, fiName = null;
		int schoolYear = 0 , semester1 = 0, times = 0 ,itemValue = 0, score = 0;
		for (int i = 0; i < teachers.size(); i++) {
			Object[] t = (Object[]) teachers.get(i);
			
			className = t[3].toString();
			feedBackName = t[4].toString();
			schoolYear = Integer.valueOf(t[5].toString());
			semester1 = Integer.valueOf(t[6].toString());
			times = Integer.valueOf(t[7].toString());
			teacherName = t[9].toString();
			courseName = t[11].toString();
			fitName = t[13].toString();
			fiName = t[15].toString();
			itemValue = Integer.valueOf(t[16].toString());
			score = Integer.valueOf(t[17].toString());
			
			if (semester1 == 1) {
				semester = "上学期";
			} else if (semester1 == 2) {
				semester = "下学期";
			}
		}
		
		Struts2Utils.setAttribute("teacher", teacher);
		Struts2Utils.setAttribute("teacherName", teacherName);
		Struts2Utils.setAttribute("courseName", courseName);
		Struts2Utils.setAttribute("fitName", fitName);
		Struts2Utils.setAttribute("fiName", fiName);
		Struts2Utils.setAttribute("fiName", itemValue);
		Struts2Utils.setAttribute("fiName", score);
	}

	@Override
	public void classes(ClassCourse classCourse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void indexItems(FeedbackItemType feedbackItemType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void baseAvgScore(FeedbackScore feedbackScore) {
		// TODO Auto-generated method stub
		
	}

}
