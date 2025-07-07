package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.dto.FoodDto;

@Controller
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody
	public Map<String, String> list1()
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "È«±æµ¿");
		map.put("hp", "010-222-3333");
		map.put("addr", "¼­¿ï °­³² ¿ª»ï");
		return map;
	}
	
	
	@GetMapping("/list2")
	@ResponseBody
	public List<FoodDto> list2()
	{
		List<FoodDto> list=new ArrayList<FoodDto>();
		
		list.add(new FoodDto("»÷µåÀ§Ä¡", "1.jpg"));
		list.add(new FoodDto("¸Á°íºù¼ö", "11.jpg"));
		list.add(new FoodDto("²¿Ä¡±¸ÀÌ", "2.jpg"));
		list.add(new FoodDto("ÇÜ¿¡±×¸¶¿ä", "10.jpg"));
		list.add(new FoodDto("Ä¡Áî±×¶óÅÁ", "5.jpg"));
		
		return list;
	}
	
	
	
}
