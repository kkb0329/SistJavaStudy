package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HappyController {

	@GetMapping("/naver/board")
	public ModelAndView naver()
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("age", "25");
		model.addObject("city", "¼­¿ï½Ã");
		
		model.setViewName("result4");
		
		
		return model;
	}
	
	@GetMapping("/shop/detail")
	public String imageResult5()
	{
		return "result5";
	}
	
	
}
