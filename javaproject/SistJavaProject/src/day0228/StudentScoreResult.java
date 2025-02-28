package day0228;

import java.util.Scanner;

class StudentScore{
	
	private String stuName;
	private int java;
	private int html;
	private int mysql;
	
	//setters & getters
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getMysql() {
		return mysql;
	}
	public void setMysql(int mysql) {
		this.mysql = mysql;
	}
	
	public double getTotal() {
		int tot = 0;
		tot = java+html+mysql;
		
		return tot;
		
	}
	public double getAverage() {
		double avg;
		avg = (java+html+mysql/3.0);
		return avg;
		
	}
	public void getPungga() {
		String pungga = null;
		if ((java+html+mysql/3.0)>=90)
		{
			System.out.println("장학생");
		}
		else if((java+html+mysql/3.0)>=80)
		{
			System.out.println("우수생");
		}
		else 
			System.out.println("재수강");
		return pungga;
	}
	
	//출력
	public static void showTitle() {
		
		System.out.println("이름\tjava\tHtml\tMysql\t총점\t평균\t평가");
		System.out.println("===============================================");
	}
	
}



public class StudentScoreResult {
	
	
	public static void showStuInfo(StudentScore [] stuScore) {
		
		StudentScore.showTitle();
		for(StudentScore s : stuScore) {
			
			System.out.println(s.getStuName()+"\t"+s.getJava()+"\t"+s.getHtml()+
					"\t"+s.getMysql()+"\t"+s.getTotal()+"\t"+s.getAverage()+"\t"+s.getPungga());
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inwon;
		
		StudentScore [] stuScores;
		
		System.out.println("입력할 학생수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		stuScores = new StudentScore[inwon];
		for(int i=0;i<inwon;i++)
		{
			stuScores[i] = new StudentScore();  //디폴트 생성자
			
			System.out.println("이름");
			String name = sc.nextLine();
			
			System.out.println("급여");
			int pay = Integer.parseInt(sc.nextLine());
			
			System.out.println("가족수는?");
			int fs = Integer.parseInt(sc.nextLine());
			
			System.out.println("초과근무시간?");
			int ts=Integer.parseInt(sc.nextLine());
		
		
		
	}
	
	

}
