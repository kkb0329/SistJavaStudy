package spring.car.data;

import java.sql.Timestamp;

public class CarDto {
  private String num;
  private String carname;
  private String carprice;
  private String carcolor;
  private String carguip;
  private Timestamp carwrteday;
  
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getCarname() {
	return carname;
}
public void setCarname(String carname) {
	this.carname = carname;
}
public String getCarprice() {
	return carprice;
}
public void setCarprice(String carprice) {
	this.carprice = carprice;
}
public String getCarcolor() {
	return carcolor;
}
public void setCarcolor(String carcolor) {
	this.carcolor = carcolor;
}
public String getCarguip() {
	return carguip;
}
public void setCarguip(String carguip) {
	this.carguip = carguip;
}
public Timestamp getCarwriteday() {
	return carwrteday;
}
public void setCarwriteday(Timestamp carwriteday) {
	this.carwrteday = carwriteday;
}
  
  
  
}
