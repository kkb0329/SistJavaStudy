package boot.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MyCarDao {

	@Autowired
	MyCarInter carInter;
	
	//insert
	public void insertCar(MycarDto dto)
	{
		carInter.save(dto); //id타입 유무에 따라서 자동으로 insert 또는 update
	}
	
	//전체출력
	public List<MycarDto> getAllDatas()
	{
		return carInter.findAll();
	}
	
	//num에대한 dto반환
	public MycarDto getData(long num)
	{
		return carInter.getById(num);
	}
	
	//수정
	public void updateCar(MycarDto dto)
	{
		carInter.save(dto); //num이 포함되어 있으므로 수정
	}
	//삭제
	public void deleteCar(long num)
	{
		carInter.deleteById(num);
	}
}
