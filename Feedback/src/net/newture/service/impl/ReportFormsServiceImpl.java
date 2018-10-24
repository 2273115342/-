package net.newture.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.ReportFormsDao;
import net.newture.domain.Feedback;
import net.newture.domain.ReportForms;
import net.newture.domain.Class;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportFormsService;
@Service
public class ReportFormsServiceImpl extends ServiceBase implements ReportFormsService {

	@Autowired
	private ReportFormsDao reportFormsDao;
	
	@Override
	@Transactional(readOnly = true)
	public void findReportForms(Integer classId) {
		List<Object[]> list =reportFormsDao.findReportForms(classId);
		List<ReportForms> list2 = new ArrayList<ReportForms>();
		for (Object[]objects : list) {
			ReportForms reportForms = new ReportForms();
			reportForms.setFeedbackId(Integer.valueOf(objects[0]+""));
			reportForms.setClassName(objects[1]+"");
			reportForms.setFiId(Integer.valueOf(objects[2]+""));
			reportForms.setFiName(objects[3]+"");
			reportForms.setFitId(Integer.valueOf(objects[4]+""));
			reportForms.setFitName(objects[5]+"");
			BigDecimal bd = new BigDecimal(Double.parseDouble(objects[6]+""));
			Double d = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			reportForms.setAvgScore(d);
			list2.add(reportForms);
		}
		Struts2Utils.setAttribute("reportFormsList", list2);
	}

	@Override
	public void findAllClasses() {
		List<Class> classes = reportFormsDao.findAllClasses();
		Struts2Utils.setAttribute("classes", classes);
	}
	
	@Override
	public void findByAccomplishFeed(Integer classId) {
		List<Feedback> feedbacks = reportFormsDao.findByAccomplishFeed(classId);
		Struts2Utils.setAttribute("feedbacks", feedbacks);
	}
}
