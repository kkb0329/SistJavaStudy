package spring.di.ex3;

public class Moim {

	String major;
	MyInfo info;
	
	public Moim(MyInfo info) {
		super();
		this.info=info;
	}
	
	public void setMajor(String major) {
		this.major=major;
	}
	
	//출력
	public void writeData()
	{
		System.out.println("회원 정보 출력");
		
		System.out.println("전공: "+major);
		System.out.println("이름: "+info.name);
		System.out.println("주소: "+info.addr);
		System.out.println("나이: "+info.age);
	}
}
