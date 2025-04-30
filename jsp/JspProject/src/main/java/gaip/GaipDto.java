package gaip;

import java.sql.Timestamp;

public class GaipDto {
   
	private String num;
	private String name;
	private String age;
	private String hp;
	private String lang;
	private String birth;
	private Timestamp gaipday;
	
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Timestamp getGaipday() {
		return gaipday;
	}
	public void setGaipday(Timestamp gaipday) {
		this.gaipday = gaipday;
	}
	
	
}
