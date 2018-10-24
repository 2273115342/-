package net.newture.dao;

import java.util.List;

public interface ReportDao {
	
	public List<Object[]> teacher(int teacherID);
	public List<Object[]> classes(int classId);
	public List<Object[]> indexItems(Integer indexId);
	public List<Object[]> baseAvgScore(Integer baseId);
}
