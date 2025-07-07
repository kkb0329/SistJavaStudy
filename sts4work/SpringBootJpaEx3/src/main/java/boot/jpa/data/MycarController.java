package boot.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class MycarController {

	@Autowired
	MyCarDao dao;
	
	@GetMapping("/carform")
	public String form()
	{
		return "addform";
	}
	
	//리스트 ..시작  / or list
	@GetMapping({"/","/list"})
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		List<MycarDto> list=dao.getAllDatas();
		
		model.addObject("count", list.size());
		model.addObject("list", list);
		
		model.setViewName("carlist");
		return model;
	}
	
	//insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute MycarDto dto)
	{
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	//수정폼
	@GetMapping("/updateform")
	public ModelAndView uform(long num)
	{
		ModelAndView model=new ModelAndView();
		
		MycarDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("updateform");
		
		return model;
	}
	
	//수정..목록
	@PostMapping("/update")
	public String update(@ModelAttribute MycarDto dto)
	{
		dao.updateCar(dto);
		
		return "redirect:list";
	}
	//삭제
	@GetMapping("/delete")
	public String carDelete(long num)
	{
		dao.deleteCar(num);
		return "redirect:list";
	}
	
}
