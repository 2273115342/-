package net.newture.domain;


public class Judge implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private Judge judge;
	private String request;
	private Integer Point;
	
	public Judge(){
		
	}
	
	public Judge getJudge() {
		return judge;
	}
	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Integer getPoint() {
		return Point;
	}
	public void setPoint(Integer point) {
		Point = point;
	}

	public Object trim() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
