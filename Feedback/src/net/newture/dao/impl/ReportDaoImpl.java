package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.ReportDao;
import net.newture.framework.DaoBase;
@Repository
public class ReportDaoImpl extends DaoBase implements ReportDao {

	@Override
	public List<Object[]> teacher(int teacherID) {
		StringBuffer sql = new StringBuffer();
		sql.append("select fb.feedback_id,");
		sql.append("	   cl.class_id,");
		sql.append("	   cl.class_name,");
		sql.append("	   fb.feedback_name,");
		sql.append("       fb.school_year,");
		sql.append("       fb.semester,");
		sql.append("       fb.times,");
		sql.append("       fs.teacher_id,");
		sql.append("       tch.name,");
		sql.append("       fs.course_id,");
		sql.append("       cr.course_name,");
		sql.append("       fit.fit_id,");
		sql.append("       fit.fit_name,");
		sql.append("       fi.fi_id,");
		sql.append("       fi.fi_name,");
		sql.append("       fi.item_value,");
		sql.append("       avg(fs.score) as score");
		sql.append("  from feedback           fb,");
		sql.append("       feedback_score     fs,");
		sql.append("       feedback_item      fi,");
		sql.append("       feedback_item_type fit,");
		sql.append("       classes            cl,");
		sql.append("       users              tch,");
		sql.append("       course             cr");
		sql.append(" where fs.feedback_id = fb.feedback_id");
		sql.append("   and fb.class_id = cl.class_id");
		sql.append("   and fs.teacher_id = tch.user_id");
		sql.append("   and fs.course_id = cr.course_id");
		sql.append("   and fs.fi_id = fi.fi_id");
		sql.append("   and fi.fit_id = fit.fit_id");
		sql.append("   and fb.status > 0");
		sql.append("   and fb.school_year = 2018");
		sql.append("   and fb.semester = 1");
		sql.append("   and fb.times = 1");
		sql.append("   and fs.course_id in (1)");
		sql.append("   and fit.fit_id in (1, 2)");
		sql.append("   and fs.teacher_id = ?");
		sql.append(" group by fb.feedback_id,");
		sql.append("          cl.class_id,");
		sql.append("          cl.class_name,");
		sql.append("          fb.feedback_name,");
		sql.append("          fb.school_year,");
		sql.append("          fb.semester,");
		sql.append("          fb.times,");
		sql.append("          fs.teacher_id,");
		sql.append("          tch.name,");
		sql.append("          fs.course_id,");
		sql.append("          cr.course_name,");
		sql.append("          fit.fit_id,");
		sql.append("          fit.fit_name,");
		sql.append("          fi.fi_id,");
		sql.append("          fi.fi_name,");
		sql.append("          fi.item_value,");
		sql.append("          fi.disp_order");
		sql.append(" order by fb.feedback_id,");
		sql.append("          cl.class_id,");
		sql.append("          fb.school_year,");
		sql.append("          fb.semester,");
		sql.append("          fb.times,");
		sql.append("          fs.teacher_id,");
		sql.append("          fs.course_id,");
		sql.append("          fit.fit_id,");
		sql.append("          fi.disp_order");
		return queryBySql(sql.toString(), new Object[]{teacherID});
	}

	@Override
	public List<Object[]> classes(int classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> indexItems(Integer indexId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> baseAvgScore(Integer baseId) {
		// TODO Auto-generated method stub
		return null;
	}


}
