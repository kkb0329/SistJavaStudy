package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.dao.AnswerDao;
import spring.mvc.dto.AnswerDto;

@Controller
public class AnswerController {

	@Autowired
	AnswerDao adao;
	
	@PostMapping("/board/ainsert")
	public String insertAnswer(
			@ModelAttribute AnswerDto dto,
			@RequestParam int currentPage)
	{
		
		//db¿¡Ãß°¡
		adao.insertAnswer(dto);
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	
	
}
