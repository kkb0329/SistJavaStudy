package spring.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.AnswerDao;
import spring.mvc.dao.BoardDao;
import spring.mvc.dto.AnswerDto;
import spring.mvc.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	BoardDao dao;
	
	@Autowired
	AnswerDao adao;
	
	@GetMapping("/board/list")
	public ModelAndView blist(
			@RequestParam(value = "currentPage",defaultValue = "1") int currentPage)
	
	{
		
		ModelAndView model=new ModelAndView();
		
		//페이징처리
		  int totalCount=dao.getTotalCount();
		  int perPage=5; //한페이지에 보여질 글의 갯수
		  int perBlock=5; //한블럭당 보여질 페이지의 갯수
		  int startNum; //db에서 가져올 글의 시작번호(mysql:0 오라클:1번)
		  int startPage; //각블럭당 보여질 시작페이지
		  int endPage;//각블럭당 보여질 끝페이지
		  int totalPage; //총페이지
		  int no; //각페이지당 출력할 시작번호
		  
		 
		  
		  //총페이지수를 구한다
		  //총글의 갯수/한페이지당 보여질개수로 나눔(7/5=1)
		  //나머지가 1이라도 있으면 무저건 1페이지추가(1+1=2페이지가 필요)
		  totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		  
		  //각블럭당 보여질 시작페이지
		  //perBlock=5일경우 현재페이지가 1~5 시작1,끝5
		  //만약 현재페이지가 13일경우는 시작11,끝15
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1;
		  
		  //총페이지가 23개일경우 마지막 블럭은 끝 25가 아니라 23이다
		  if(endPage>totalPage)
			  endPage=totalPage;
		  
		  //각페이지에서 보여질 시작번호
		  //예: 1페이지-->0  2페이지-->5 3페이지-->10...
		  startNum=(currentPage-1)*perPage;
		  
		  //각페이지당 출력할 시작번호
		  //예를들어 총글갯수가 23   1페이지: 23  2페이지:18  3페이지: 13.....
		  no=totalCount-(currentPage-1)*perPage;
		  
		  //전체데이타
		  List<BoardDto> list=dao.getList(startNum, perPage);
		  
		  //list에 각글에대한 댓글갯수 추가하기
		  for(BoardDto bd:list)
		  {
			  bd.setAcount(adao.getAnswerList(bd.getNum()).size());
		  }
		  
		  

		  //출력에 필요한 변수들을 request에저장
		  model.addObject("list", list); //댓글 포함해서 전달
		  model.addObject("startPage", startPage);
		  model.addObject("endPage", endPage);
		  model.addObject("totalPage", totalPage);
		  model.addObject("totalCount", totalCount);
		  model.addObject("no", no);
		  model.addObject("currentPage", currentPage);
		  
		  
		  
		
		model.setViewName("/board/boardlist");
		return model;
	}
	
	//글쓰기 폼으로 이동
	//새글,답글 모두 해당
	@GetMapping("/board/form")
	public ModelAndView form1(
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int currentPage)
	{
		ModelAndView model=new ModelAndView();
		
		//답글일때만 넘어오는 값(4개)
		//새글일때는 모두 null이므로 defaultValue값으로 전달
		model.addObject("num", num);
		model.addObject("regroup", regroup);
		model.addObject("restep", restep);
		model.addObject("relevel", relevel);
		model.addObject("currentPage", currentPage);
		
		//출력테스트
		System.out.println(currentPage+","+num); //새글이면 null,답글이면 숫자
		
		//제목에 답글일경우 해당제목 넣어보기,새글일경우""
		String subject="";
		if(num>0) {
			subject=dao.getData(num).getSubject();
		}
		model.addObject("subject", subject);
		model.setViewName("/board/writeform");
		return model;
	}
	
	//insert
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session)
	{
		
		//업로드할 실제경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		//사진선택 안하면 "no",하면 날짜붙힌파일에 db에는 ,로 나열
		
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fname=sdf.format(new Date())+"_"+f.getOriginalFilename();
				photo+=fname+",";
				
				//업로드
				try {
					f.transferTo(new File(path+"\\"+fname));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//photo마지막 컴마 제거
			photo=photo.substring(0, photo.length()-1);
		}
		
		//dto에 photo넣어주기
		dto.setPhoto(photo);
		
		//dao insert
		dao.insertBoard(dto);
		
		return "redirect:list";
	}
	
	
	//제목누르면 디테일 페이지로 가기
	 @GetMapping("/board/content") 
	 public ModelAndView content(
			 @RequestParam int num,
			 @RequestParam int currentPage)
	 {
		 ModelAndView model=new ModelAndView();
		 
		 //조회수
		 dao.updateReadcount(num);
		 //dto
		 BoardDto dto=dao.getData(num);
		 
		 model.addObject("dto", dto);
		 model.addObject("currentPage", currentPage);
		 
		 
		 //num에 해당하는 댓글을 db에서 가져와서 보낸다
		 List<AnswerDto> alist=adao.getAnswerList(num);
		 
		 //댓글이 있을때만 보내면 된다
		 model.addObject("acount", alist.size());
		 model.addObject("alist", alist);
		 
		 
		 model.setViewName("/board/content");
		 
		 return model;
	 }
	
	//수정폼 띄우기
	 @GetMapping("/board/updateform")
	 public ModelAndView uform(@RequestParam int num,
			 @RequestParam int currentPage)
	 {
		 ModelAndView model=new ModelAndView();
		 
		 BoardDto dto=dao.getData(num);
		 
		 model.addObject("dto", dto);
		 model.addObject("currentPage", currentPage);
		 model.setViewName("/board/updateform");
		 
		 return model;
	 }
	
	//수정submit
	 @PostMapping("/board/update")
		public String update(@ModelAttribute BoardDto dto,
				@RequestParam ArrayList<MultipartFile> upload,
				HttpSession session,
				@RequestParam int currentPage)
		{
			
			//업로드할 실제경로
			String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			System.out.println(path);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			
			String photo="";
			
			//사진선택 안하면 "no",하면 날짜붙힌파일에 db에는 ,로 나열
			
			if(upload.get(0).getOriginalFilename().equals(""))
				photo=null;
			else {
				
				
				//수정전의 이전의 사진들 지우고
				String old_photo=dao.getData(dto.getNum()).getPhoto();
				
				//,분리
				String [] old_fName=old_photo.split(",");
				for(String f:old_fName)
				{
					File file=new File(path+"\\"+f);
					file.delete();
				}
				
				
				
				for(MultipartFile f:upload)
				{
					String fname=sdf.format(new Date())+"_"+f.getOriginalFilename();
					photo+=fname+",";
					
					//업로드
					try {
						f.transferTo(new File(path+"\\"+fname));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//photo마지막 컴마 제거
				photo=photo.substring(0, photo.length()-1);
			}
			
			//dto에 photo넣어주기
			dto.setPhoto(photo);
			
			//dao 수정
			dao.updateBoard(dto);
			
			return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
		}
	
	
	 //삭제 후 목록
	 @GetMapping("/board/delete")
	 public String delete(@RequestParam int num,
			 @RequestParam int currentPage,
			 HttpSession session)
	 {
		 //photo폴더의 num에 해당하는 사진도 지운다
		 String photo=dao.getData(num).getPhoto();
		 
		 if(!photo.equals("no")) {
			 
			 //,로분리
			 String [] fName=photo.split(",");
			 
			 //실제업로드경로
			 String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			 
			 for(String f:fName)
			 {
				 File file=new File(path+"\\"+f);
				 file.delete();
			 }
			 
		 }
		 
		 //db도 삭제
		 dao.deleteBoard(num);
		 
		 return "redirect:list?currentPage="+currentPage;
	 }
	 
	 //ajaxlist로 이동해서 ....
	 @GetMapping("/board/list1")
	 public String list1()
	 {
		 return "/board/ajaxlist";
	 }
	 
	
}
