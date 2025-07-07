package spring.mvc.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@GetMapping("/form1")
	public String form1()
	{
		return "upload/form1";
	}
	
	@PostMapping("/save1")
	public ModelAndView read1(@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpServletRequest reauest)
	{
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로구하기
		String path=reauest.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		String fileName=photo.getOriginalFilename();//업로드한 파일명
		
		//현재날짜와 시간이용해서 파일명저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		if(!fileName.equals(""))
		{
			fileName=sdf.format(new Date())+"_"+fileName;
			
			//path에 업로드 해주기
			try {
				photo.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			fileName="no"; //업로드 안했을경우
		}
		
		
		
		model.addObject("fileName", fileName);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/result1");
		
		return model;
	}
}
