package spring.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.dao.AnswerDao;
import spring.mvc.dao.BoardDao;
import spring.mvc.dto.BoardDto;

@RestController
public class AnswerRestController {

	@Autowired
	AnswerDao adao;
	@Autowired
	BoardDao bdao;
	
	@GetMapping("/board/adelete")
	public HashMap<String, Integer> answerDelete(
			@RequestParam int idx,
			@RequestParam String pass)
	{
		int check=adao.getCheckPass(idx, pass);
		
		if(check==1) //비번이 맞는경우
			adao.deleteAnswer(idx);
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("check", check); //{"check":1}
		
		return map;
	}
	
	
	
	//전체출력
	@GetMapping("/rest/list1")
	public List<BoardDto> allList()
	{
		List<BoardDto> list=bdao.getAllList();
		
		for(BoardDto dto:list)
		{
			if(!dto.getPhoto().equals("no"))
			{
				String [] photos=dto.getPhoto().split(",");
				dto.setPhoto(photos[0]); //첫번째 사진으로 넣기
			}
		}
		
		
		return list;
	}
	
	
	
	
}
