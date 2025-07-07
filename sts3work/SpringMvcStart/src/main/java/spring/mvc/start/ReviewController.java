package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	
	//nice/hi에 리소스의 아무 이미지나 출력할것(hi.jsp)
	@GetMapping("/nice/hi")
	public String hi()
	{
		return "review/hi";
	}
	
	
	//happy  에는 msg값전달...그아래 WEB-INF의 이미지 하나 출력할것(nice.jsp)
	@GetMapping("/happy")
	public String nice(Model model)
	{
		model.addAttribute("msg", "구두 이미지 출력");
		
		return "review/nice";
	}
}
