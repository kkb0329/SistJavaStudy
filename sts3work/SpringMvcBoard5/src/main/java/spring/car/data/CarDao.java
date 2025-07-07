package spring.car.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements CarDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<CarDto> getAllCarList() {
		// TODO Auto-generated method stub
		return session.selectList("getAllOfMyCar");
	}

	@Override
	public void insertMycar(CarDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMycar", dto);
	}

	@Override
	public CarDto getOneData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfCar", num);
	}

	@Override
	public void updateMycar(CarDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfCar", dto);
	}

}
