package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.JudgeDao;
import net.newture.domain.Judge;
import net.newture.framework.DaoBase;

@Repository
public class JudgeDaoImpl extends DaoBase implements JudgeDao{
	
	public List<Judge> findByJudge(){
		return hibernateTemplate.find("from.Judge");
	}
	public void save(Judge judge){
		hibernateTemplate.save(judge);
	}
	public void update(Judge judge){
		hibernateTemplate.update(judge);
	}
	public void delete(Judge judge){
		hibernateTemplate.delete(judge);
	}
	public void findByjudgeId(Integer judgeId){
		
	}
	@Override
	public Judge findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Judge> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Judge findByjudgeId(String JudgeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
