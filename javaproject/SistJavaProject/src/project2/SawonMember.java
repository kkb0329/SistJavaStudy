package project2;

import java.sql.Date;

public class SawonMember {
	private int num; 
	private String name; 
	private String gender; 
	private String buseo; 
	private String pay; 
	private Date hireday;

	
	public SawonMember(int num, String name, String gender, String buseo, String pay, Date hireday) {
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.buseo = buseo;
		this.pay = pay; 
		this.hireday = hireday;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBuseo() {
		return buseo;
	}

	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	public String getPay() {
		return pay;
	} 

	public void setPay(String pay) {
		this.pay = pay;
	} 

	public Date getHireday() {
		return hireday;
	}

	public void setHireday(Date hireday) {
		this.hireday = hireday;
	}
	
	public class PayUtil {
	    public static String parsePay(String text) {
	        if (text == null || text.isEmpty()) {
	            throw new IllegalArgumentException("급여 값이 유효하지 않습니다.");
	        }
	        return text.replace("￦", "").replace(",", "").trim();
	    }
	}
}
