package spring.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.car.data.CarDao;
import spring.car.data.CarDto;

@Controller
public class MyCarController {

	@Autowired
	CarDao dao;
	
	@GetMapping("/car/list")
	public String list(Model model)
	{
		//전체리스트 가져오기
		List<CarDto> list=dao.getAllCarList();
		
		//request에저장
		model.addAttribute("totalCount", list.size());
		model.addAttribute("list", list);
		
		return "mycar/carlist";
	}
	
	//입력폼으로 가기
	@GetMapping("/car/writeform")
	public String carform()
	{
		return "mycar/carform";
	}
	
	//insert성공후 리스트
	//sql==>dao==>controller(호출의 역순으로..)
	@PostMapping("/car/carinfo")
	public String insert(@ModelAttribute CarDto dto)
	{
		dao.insertMycar(dto);
		return "redirect:list";
	}
	
	
	//수정폼으로 가기
	@GetMapping("/car/updateform")
	public String updateform(@RequestParam String num,Model model)
	{
		CarDto dto=dao.getOneData(num);
		model.addAttribute("dto", dto);
		
		return "mycar/updateform";
	}
	
	//수정
	@PostMapping("car/carupdate")
	public String update(@ModelAttribute CarDto dto)
	{
		dao.updateMycar(dto);
		return "redirect:list";
	}
	
}
