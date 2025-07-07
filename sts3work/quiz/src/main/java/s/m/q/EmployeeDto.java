package s.m.q;

public class EmployeeDto {

	private String sname;
    private int pay;
    private String buseo;
    private String ipsaday;

    // 기본 생성자
    public EmployeeDto() {}

    // 모든 필드 생성자
    public EmployeeDto(String sname, int pay, String buseo, String ipsaday) {
        this.sname = sname;
        this.pay = pay;
        this.buseo = buseo;
        this.ipsaday = ipsaday;
    }

    // Getter & Setter
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getBuseo() {
        return buseo;
    }

    public void setBuseo(String buseo) {
        this.buseo = buseo;
    }

    public String getIpsaday() {
        return ipsaday;
    }

    public void setIpsaday(String ipsaday) {
        this.ipsaday = ipsaday;
    }
	
	
}
