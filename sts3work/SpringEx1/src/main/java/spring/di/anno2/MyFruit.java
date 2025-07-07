package spring.di.anno2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFruit {

	//@Autowired  //error: 매칭할 Fruit이 2개라서 에러가 남..정확한 이름을쓰는 @Resource필요
	//@Resource(name = "tmgo")
	@Resource(name = "pmgo")
	Friut fruit;
	
	public void writeFruit()
	{
		System.out.println("***내가 좋아하는 과일은***");
		fruit.writeFriutName();
	}
}
