package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", "이영자");
		model.addObject("addr", "서울시 강남구 역삼2동");
		model.addObject("hp", "010-2222-3333");
		model.setViewName("list");
		return model;
	}
}
