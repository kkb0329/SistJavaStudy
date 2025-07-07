package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	
	@GetMapping("quiz/lunch/burger")
	public ModelAndView quiz1()
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("title", "이미지 출력과제");
		mview.addObject("stuName", "이수연");
		
		mview.setViewName("quiz1");
		
		return mview;
	
	}
}
