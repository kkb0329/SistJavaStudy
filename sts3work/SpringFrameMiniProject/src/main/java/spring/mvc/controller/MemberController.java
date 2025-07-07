package spring.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.MemberDao;
import spring.mvc.dto.MemberDto;


@Controller
public class MemberController {

	@Autowired
	MemberDao dao;
	
	
		//멤버리스트
	@GetMapping("/member/list")
	public String memberlist(Model model)
	{
		List<MemberDto> list=dao.getAllMembers();
		model.addAttribute("list", list);
		return "/member/memberlist";
	}
	
	
	  //회원가입폼 
	@GetMapping("/member/form")
	public String form1()
	{
		return "/member/memberform";
	}
	
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idcheck(
			@RequestParam String id)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		int count=dao.getIdCount(id);
		System.out.println(count);
		
		map.put("count", count);
		
		return map;
	}
	
	//insert
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto)
	{
		dao.insertMember(dto);
		return "redirect:list";
	}
	
	//마이페이지 가기
	
		@GetMapping("/member/myinfo")
		public String mypage(Model model)
		{
			List<MemberDto> list=dao.getAllMembers();
			model.addAttribute("list", list);
			return "/member/myinfo";
		}
		
		//수정폼나오게
		@GetMapping("/member/updateform")
		public ModelAndView updateform(@RequestParam String num)
		{
			ModelAndView model=new ModelAndView();
			
			MemberDto dto=dao.getMember(num);
			model.addObject("dto", dto);
			model.setViewName("/member/updateform");
			
			return model;
		}
		
		//수정하기
		@PostMapping("/member/update")
		public String update(@ModelAttribute MemberDto dto)
		{
			//비번체크
			int n=dao.passCheck(dto.getNum(), dto.getPass());
			
			if(n==1) {
				//비번이 맞으면 마이페이지로
				dao.updateMember(dto);
				return "redirect:myinfo";
			}else {
				
				return "/member/passfail";
			}
			
			
		}
		
		//마이페이지에서 본인이 탈퇴
		@GetMapping("/member/delete")
		public String delGaip(@RequestParam String num,HttpSession session)
		{
			
			dao.deleteMember(num);
			//세션도삭제
			session.removeAttribute("myid");
			session.removeAttribute("loginok");
			return "redirect:/home";
		}
		
		//멤버리스트의 강퇴처리_Ajax
		@GetMapping("/member/memdel")
		@ResponseBody
		public void deleteMember(@RequestParam String num)
		{
			dao.deleteMember(num);
		}
		
		
}
