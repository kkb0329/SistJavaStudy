package hello;

import java.sql.Timestamp;

public class HelloDto {

	private String num;
	private String name;
	private String addr;
	private String hp;
	private Timestamp curdate;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public Timestamp getCurdate() {
		return curdate;
	}
	public void setCurdate(Timestamp curdate) {
		this.curdate = curdate;
	}
	
	
}
