package spring.di.anno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic")
public class LogicController {

	//@Autowired : 자동으로 똑같은 이름의 빈을 찾아서 주입해준다. (타입으로 찾음)
	@Autowired
	DaoInter daoInter;
	
	//생성자
	public LogicController(MyDao dao) {
		this.daoInter=dao;
	}
	
	//insert
	public void insert(String str)
	{
		daoInter.insertData(str);
	}
	
	//delete
	public void delete(String num)
	{
		daoInter.deleteData(num);
	}
}
