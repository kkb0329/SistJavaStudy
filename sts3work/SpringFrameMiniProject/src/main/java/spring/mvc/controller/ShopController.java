package spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.MyshopDaoInter;
import spring.mvc.dto.MyshopDto;

@Controller
public class ShopController {
	
	@Autowired
	MyshopDaoInter dao;

	/*@GetMapping("/shop/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		List<MyshopDto> list=dao.getAllSangpums();
		
		model.addObject("count", list.size());
		model.setViewName("myshop/shoplist");
		
		return model;
	}*/
}
