package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.CourseDao;
import net.newture.domain.Course;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.MD532;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.CourseService;
@Service
public class CourseServiceImpl extends ServiceBase implements CourseService {

	@Autowired
	CourseDao courseDao;
	private Object condName;
	@Override
	public void findCourseAll() {
		List<Course> courseList =courseDao.findByCourse();
		Struts2Utils.setAttribute("courseList", courseList);
	}
	@Override
	public int saveCourse(Course course) {
		// 校验课程名是否存在
		/*Course findCourse = courseDao.findByCourseName(course.getCourseName());
		if (findCourse != null) {
			Struts2Utils.setAttribute("message1", "课程名已经被注册!");
			return -1;
		}*/
		// 保存
		this.courseDao.save(course);
		return 1;
	}
	@Override
	public int updateCourse(Course course) {
		this.courseDao.update(course);
		return 1;
	}
	@Override
	public void deleteCourse(Course course) {
		this.courseDao.delete(course);
		Struts2Utils.setAttribute("message", "删除课程信息成功！");
	}
	@Override
	public int deleteCourse(Integer id) {
		// 根据主键编号查找课程对象
				Course course = courseDao.findById(id);
				if (course == null) {
					Struts2Utils.setAttribute("message", "删除用户信息出错：找不到指定用户");
					return -1;
				} else {
					// 删除该对象
					courseDao.delete(course);
					return 1;
				}
	}
	@Override
	public String batchDeleteCourse(String[] courseId) {
		StringBuffer deletedCourse = new StringBuffer();
		int count = 0;
		if(courseId.length>0){
			//循环删除课程
			for (int i = 0; i < courseId.length; i++) {
				try{
					this.deleteCourse(Integer.valueOf(courseId[i]));
					count++;
					if(count%10==0) deletedCourse.append(courseId[i]+"<br/>");
					else deletedCourse.append(courseId[i]+"、");
				}catch (Exception e) {
					if(deletedCourse.length()>0){
						return "已删除id为："+deletedCourse+"的课程,删除课程id为"+courseId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}else{
						return "还未删除课程，在删除课程id为"+courseId[i]+"时信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
								: "") + "<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
										: "");
					}
				}
				
			}
		}else{
			return "所要删除的课程为空";
		}
		return deletedCourse+"";
	}
	@Override
	public Course findCourseById(Integer id) {
		return this.courseDao.findById(id);
	}
	@Override
	public void getCodeTable() {
		
	}
	@Override
	public Course findByCond(String coursenName, String condvalue) {
		// 处理查询条件
				Object condValueObj = condvalue;
				if (condName.equals("courseId")) {
					Integer i;
					try {
						i = Integer.valueOf(condvalue);
					} catch (Exception e) {
						Struts2Utils.setAttribute("message", "查询用户信息失败：输入的用户编号 " + condvalue + " 不是正确的数字格式！");
						return null;
					}
					condValueObj = i;
				}
				// 执行查询
				List<Course> list = courseDao.findByCond(condName, condValueObj);
				if (list == null || list.size() == 0) {
					Struts2Utils.setAttribute("message", "查询用户信息失败：没有找到指定的用户");
					return null;
				} else if (list.size() > 1) {
					Struts2Utils.setAttribute("message", "查询用户信息失败：查找到多个用户");
					return null;
				} else {
					return list.get(0);
				}
	}

}
