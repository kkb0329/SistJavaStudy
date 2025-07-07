package spring.di.ex4;

public class SawonData {

	private String sawonName;
	private int pay;
	private String ipsaday;
	
	//디폴트생성자
	public SawonData() {
		// TODO Auto-generated constructor stub
	}
	
	//사원명..생성자주입
	public SawonData(String name) {
		this.sawonName=name;
	}
	
	//급여,입사데이..setter주입

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getIpsaday() {
		return ipsaday;
	}

	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}

	
	
}
