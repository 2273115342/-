package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.SuggestionDao;
import net.newture.domain.Suggestion;
import net.newture.domain.TeachingBase;
import net.newture.domain.User;

import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SuggestionService;

@Service
public class SuggestionServiceImpl extends ServiceBase implements
		SuggestionService {

	@Autowired
	private SuggestionDao suggestionDao;

	@Override
	public int saveSuggestion(Suggestion suggestion) {
		suggestionDao.save(suggestion);
		return 1;
	}

	@Override
	public int updateSuggestion(Suggestion suggestion) {
		suggestionDao.update(suggestion);
		return 1;
	}


//	@Override
//	public int deleteTeachingBase(Integer id) {
//		Suggestion suggestion = suggestionDao.findById(id);
//		if (suggestion == null) {
//			Struts2Utils.setAttribute("message", "删除个人建议信息出错：找不到指定用户");
//			return -1;
//		} else {
//			// 删除该对象
//			suggestionDao.delete(suggestion);
//			return 1;
//		}
//	}

	@Override
	public Suggestion findSuggestionById(Long id) {
		return suggestionDao.findById(id);
	}

	@Override
	public void findAllSuggestion() {
		List suggestion = suggestionDao.findAll();
		Struts2Utils.setAttribute("suggestion", suggestion);

	}

	@Override
	public void findByCond(String condName, String condValue) {
		if(condName.equals("TEACHER_ID")){ //根据教师id查询
			List<Suggestion> lists = new ArrayList<Suggestion>();
			List<Object[]> list = suggestionDao.findByTeacherId(Integer.valueOf(condValue));
			for (int i = 0; i < list.size(); i++) {
				Suggestion suggestion = new Suggestion();
				suggestion.setSugContent(list.get(i)+"");
				lists.add(suggestion);
			}
			Struts2Utils.setAttribute("lists", lists);
		}else{ //根据学生查询
			
		}
		
/*		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("message", "查询用户信息失败：没有找到指定的用户");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("message", "查询用户信息失败：查找到多个用户");
			return null;
		} else {
			return list.get(0);
		}*/
	}

	@Override
	public void findByStudentId(Integer studentId) {
		List<Object[]> list = suggestionDao.findByStudentId(studentId);
		List<User> teachersList = new ArrayList<User>();
		for(Object []object : list){
			User user = new User();
			user.setUserId(Integer.valueOf(object[0].toString()));
			user.setName(object[2].toString());
			teachersList.add(user);
		}
		Struts2Utils.setAttribute("teachersList", teachersList);
	}

	@Override
	public int deleteSuggestion(Long id) {
		Suggestion suggestion = suggestionDao.findById(id);
		if (suggestion == null) {
			Struts2Utils.setAttribute("message", "删除个人建议信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			suggestionDao.delete(suggestion);
			return 1;
		}
	}



}
