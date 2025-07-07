package boot.mvc.coffee;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public TestDto hello()
	{
		TestDto dto=new TestDto();
		
		dto.setName("나나");
		dto.setAddr("서울시 강동구");
		
		return dto;
	}
	
	@GetMapping("/shop/list")
	public List<ShopDto> list()
	{
		List<ShopDto> list=new Vector<>();
		
		ShopDto s1=new ShopDto();
		s1.setSangpum("텀블러");
		s1.setSu(10);
		s1.setPrice(25000);
		list.add(s1);
		
		ShopDto s2=new ShopDto();
		s2.setSangpum("커피");
		s2.setSu(20);
		s2.setPrice(10000);
		list.add(s2);
		
		
		
		return list;
	}
	
}
