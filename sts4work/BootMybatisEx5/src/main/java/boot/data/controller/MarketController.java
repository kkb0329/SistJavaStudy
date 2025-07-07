package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MarketDto;
import boot.data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {

	@Autowired
	MarketMapperInter mapper;
	
	@GetMapping({"/","/list"})
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		int totalCount=mapper.getTotalCount();
		
		model.addObject("count", totalCount);
		model.setViewName("market/marketlist");
		
		return model;
	}
	
	@GetMapping("/addform")
	public String form()
	{
		return "market/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals(""))
			dto.setPhotoname(null);
		else {
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+"_"+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
			//실제업로드
			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db에저장
		mapper.insertMarket(dto);
		
		return "redirect:list";
	}
	
}
