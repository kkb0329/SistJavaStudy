package spring.mvc.summer;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dto.SangpumDto;

@Controller
public class ShopController {

	@GetMapping("/cat/form2")
	public String form2()
	{
		return "cat/shopform";
	}
	
	@PostMapping("/cat/process2")
	public String process2(@ModelAttribute SangpumDto dto)
	{
		
		return "cat/shopresult";
	}
	
	//¸ÊÆûÀ¸·Î °¡±â
	@GetMapping("/cat/form3")
	public String form3()
	{
		return "cat/mapform";
	}
	
	
	//¸ÊÆû submitÇÑÈÄ mapresult·Î ÀÌµ¿
	@PostMapping("/cat/process3")
	public ModelAndView process3(
			@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", map.get("name"));
		model.addObject("java", map.get("java"));
		model.addObject("spring", map.get("spring"));
		model.addObject("oracle", map.get("oracle"));
		
		model.setViewName("cat/mapresult");
		return model;
	}
	
}
