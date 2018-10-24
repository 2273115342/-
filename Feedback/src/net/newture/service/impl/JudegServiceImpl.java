package net.newture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.JudgeDao;
import net.newture.domain.Judge;
import net.newture.framework.ServiceBase;
import net.newture.service.JudgeService;

@Service
public class JudegServiceImpl extends ServiceBase implements JudgeService{

	@Autowired
	private JudgeDao judgeDao;
	
	@Transactional
	public int saveJudge(Judge judge){
		judgeDao.save(judge);
		return 1;		
	}

	@Override
	public int savejudge(Judge judge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatejudge(Judge judge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteJudge(Judge judge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteJudge(Integer judgeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String batchDeleteJudge(String[] judgeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Judge findJudgeById(Integer judgeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findJudgeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCodeTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Judge findByCond(Judge judge, String condvalue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAllJudge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateJudge(Judge judge) {
		// TODO Auto-generated method stub
		return 0;
	}


}
