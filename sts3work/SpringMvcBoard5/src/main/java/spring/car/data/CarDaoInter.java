package spring.car.data;

import java.util.List;

public interface CarDaoInter {
  
	public List<CarDto> getAllCarList();
	public void insertMycar(CarDto dto);
	public CarDto getOneData(String num);
	public void updateMycar(CarDto dto);
}
