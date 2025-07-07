package boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import boot.dto.QuizDto;

@Controller
public class QuizController {
  
	@GetMapping({"/","/quiz/form"})
	public String form()
	{
		return "form";
	}
	
	@PostMapping("/quiz/foodshow")
	public String show(@ModelAttribute QuizDto dto)
	{
		return "show";
	}
	
}
