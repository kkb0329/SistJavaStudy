package spring.di.ex4;

public class Sawon {
  
	SawonData data;
	
	public Sawon(SawonData data) {
		this.data=data;
	}
	
	//출력
	public void writeData()
	{
		System.out.println("사원명: "+data.getSawonName());
		System.out.println("급여: "+data.getPay());
		System.out.println("입사일: "+data.getIpsaday());
	}
  
}
