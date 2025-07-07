package boot.mvc.coffee;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContriller {

	
	@GetMapping("/test")
	public TestDto hello() {
		
		TestDto dto=new TestDto();
		
		dto.setName("나나");
		dto.setAddr("서울시 강동구");
		
		
		return dto;
		
		
		
		
	}
	
	@GetMapping("/shop/list")
	public List<ShopDto> list() {
		
		List<ShopDto> sdto=new Vector<>();
		
		ShopDto s1=new ShopDto();
		
		s1.setSangpum("물통");
		s1.setSu(20);
		s1.setPrice(25000);
		
		sdto.add(s1);
		
		
		
		return sdto;
		
		
	}
	
	
}
