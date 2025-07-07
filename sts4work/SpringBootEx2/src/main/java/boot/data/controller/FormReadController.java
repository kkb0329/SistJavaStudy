package boot.data.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.InfoDto;

@Controller
public class FormReadController {

	//form1을 읽어서 result1에서 결과출력
	@PostMapping("/read1")
	public ModelAndView read1(
			@RequestParam String name,
			@RequestParam int java,
			@RequestParam int spring)
	{
		ModelAndView model=new ModelAndView();
		//request에 저장
		model.addObject("name", name);
		model.addObject("java", java);
		model.addObject("spring", spring);
		model.addObject("tot", java+spring);
		model.addObject("avg", (java+spring)/2.0);
		
		//포워드경로
		model.setViewName("result/result1");
		return model;
	}
	
	//form2를 읽어서 result2에 출력
	@PostMapping("/read2")
	public String read2(@ModelAttribute InfoDto dto)
	{
		return "result/result2";
	}
	
	//form3를 읽어서 result3로 출력
	//map으로 읽을경우 폼의 name이 key값이고 입력값이 value값이다
	@PostMapping("/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("irum", map.get("irum"));
		model.addObject("mbti", map.get("mbti"));
		model.addObject("major", map.get("major"));
		
		model.setViewName("result/result3");
		return model;
	}
	
	
	
}
