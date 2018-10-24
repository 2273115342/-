package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.ReportFormsDao;
import net.newture.framework.DaoBase;

/**
 * 用一句话来描述这个类的作用
 * @author js
 *  2018年6月30日 下午11:52:40
 */
@Repository
public class ReportFormsDaoImpl extends DaoBase implements ReportFormsDao {

	@Override
	public List findReportForms(Integer classId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select fs.feedback_id, ");
		sql.append(" cl.class_name, ");
		sql.append(" fs.fi_id, ");
		sql.append(" fi.fi_name, ");
		sql.append(" fit.fit_id, ");
		sql.append(" fit.fit_name, ");
		sql.append(" avg(fs.score)  ");
		sql.append(" from feedback_score fs, ");
		sql.append(" feedback_item fi, ");
		sql.append(" users u, ");
		sql.append(" course c, ");
		sql.append(" classes cl, ");
		sql.append(" feedback fd, ");
		sql.append(" feedback_item_type fit  ");
		sql.append(" where fs.fi_id = fi.fi_id(+)  ");
		sql.append(" and u.user_id = fs.student_id  ");
		sql.append(" and cl.class_id = u.class_id  ");
		sql.append(" and fs.course_id = c.course_id  "); 
		sql.append(" and cl.class_id = ? ");
		sql.append(" and fd.feedback_id = fs.feedback_id ");
		sql.append(" and fi.fit_id = fit.fit_id ");
		sql.append(" group by fs.fi_id, ");
		sql.append(" fs.feedback_id, ");
		sql.append(" cl.class_name, ");
		sql.append(" fit.fit_id,  ");
		sql.append(" fit.fit_name,  ");
		sql.append(" fi.fi_name  ");
		sql.append(" order by fs.feedback_id, ");
		sql.append(" cl.class_name");
		return queryBySql(sql.toString(), new Object[]{classId});
	}

	@Override
	public List findAllClasses() {
		return this.hibernateTemplate.find("from Class");
	}

	@Override
	public List findByAccomplishFeed(Integer classId) {
		return this.hibernateTemplate.find("from Feedback where class_id = ? and(status = 3 or status = 1)",new Object[]{classId});
	}
	
}
