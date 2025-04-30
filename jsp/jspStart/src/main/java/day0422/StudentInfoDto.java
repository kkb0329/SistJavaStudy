package day0422;

public class StudentInfoDto {

	private String stu_name;
	private String stu_addr;
	private int score;
	
	public StudentInfoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfoDto(String name,String addr,int score) {
		stu_name=name;
		stu_addr=addr;
		this.score=score;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_addr() {
		return stu_addr;
	}

	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
