package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.SuggestionDao;
import net.newture.domain.Suggestion;
import net.newture.framework.DaoBase;
@Repository
public class SuggestionDaoImpl extends DaoBase implements SuggestionDao {

	@Override
	public void save(Suggestion suggestion) {
		hibernateTemplate.save(suggestion);
	}

	@Override
	public void update(Suggestion suggestion) {
		hibernateTemplate.update(suggestion);
	}

	@Override
	public void delete(Suggestion suggestion) {
		hibernateTemplate.delete(suggestion);
	}

	@Override
	public Suggestion findById(Long id) {
		return hibernateTemplate.get(Suggestion.class,id);
	}
	@Override
	public List<Suggestion> findAll() {
		return hibernateTemplate.find("from Suggestion");
	}

	@Override
	public List<Suggestion> findByTeacherId(Integer id) {
		String sql = "select sug_content from suggestion where teacher_id = ? ";
		return queryBySql(sql,new Object[]{id});
	}

	@Override
	public List<Object[]> findByStudentId(Integer studentId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.user_id,cc.class_id,u.name,cl.class_name  ");
		sql.append(" from class_course cc,users u,classes cl   ");
		sql.append(" where cl.class_id=cc.class_id  ");
		sql.append(" and cc.teacher_id = u.user_id  ");
		sql.append(" and  cc.class_id =  ");
		sql.append(" (select u.class_id  ");
		sql.append(" from users u,classes c  ");
		sql.append(" where u.class_id = c.class_id  ");
		sql.append(" and u.user_id=?) ");
		return queryBySql(sql.toString(),new Object[]{studentId});
	}

	

}
