package net.newture.service.impl;

import org.springframework.stereotype.Service;

import net.newture.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{

	@Override
	public int saveClass(Class classes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateClass(Class classes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class findClassById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteClass(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String batchDeleteClass(String[] classesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAllclass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class findByCond(String className, String classValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
