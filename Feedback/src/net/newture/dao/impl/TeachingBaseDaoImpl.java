package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.TeachingBaseDao;
import net.newture.domain.TeachingBase;
import net.newture.domain.User;
import net.newture.framework.DaoBase;
@Repository
public class TeachingBaseDaoImpl extends DaoBase implements TeachingBaseDao {

	@Override
	public void save(TeachingBase teachingBase) {
		hibernateTemplate.save(teachingBase);
	}

	@Override
	public void update(TeachingBase teachingBase) {
		hibernateTemplate.update(teachingBase);
	}

	@Override
	public void delete(TeachingBase teachingBase) {
		hibernateTemplate.delete(teachingBase);
	}

	@Override
	public TeachingBase findById(Integer id) {
		return hibernateTemplate.get(TeachingBase.class, id); 
	}

	@Override
	public List<TeachingBase> findAll() {
		return hibernateTemplate.find("from TeachingBase");
	}

	@Override
	public TeachingBase findByTeachingBaseName(String teachingBaseName) {
		List list = hibernateTemplate.find("from TeachingBase where baseName  = ?", teachingBaseName);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (TeachingBase)list.get(0);
		}
	}

	@Override
	public List<TeachingBase> findByCond(String condName, Object condValue) {
		String hql = "from TeachingBase where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}

}
