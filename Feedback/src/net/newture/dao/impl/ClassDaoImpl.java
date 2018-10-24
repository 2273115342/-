package net.newture.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import net.newture.dao.ClassDao;
import net.newture.domain.Class;
import net.newture.framework.DaoBase;

@Repository
public class ClassDaoImpl extends DaoBase implements ClassDao {

	@Override
	public void save(Class classes) {
		hibernateTemplate.save(classes);
	}

	@Override
	public void update(Class classes) {
		hibernateTemplate.update(classes);
	}

	@Override
	public void delete(Class classes) {
		hibernateTemplate.delete(classes);
	}

	@Override
	public Class findById(Integer id) {
		return hibernateTemplate.get(Class.class, id); 
	}

	@Override
	public List<Class> findAll() {
		return hibernateTemplate.find("from Class");
	}

	@Override
	public List<Class> findByCond(String condName, Object condValue) {
		String hql = "from Class where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}

	@Override
	public Class findByTeachingBaseName(String teachingBaseName) {
		// TODO Auto-generated method stub
		return null;
	}

}
