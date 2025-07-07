package s.m.q;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class SawonController {

	
	@GetMapping("/")
	public String form()
	{
		return "start";
	}
	
	
	@GetMapping("/sawon/sawonform")
	public String sawonForm() {
	    return "sawonform";
	}
	
	@PostMapping("/sawon/info")
	public ModelAndView read2(@ModelAttribute EmployeeDto dto)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto);
		model.setViewName("sawoninfo");
		return model;
	}
	
}