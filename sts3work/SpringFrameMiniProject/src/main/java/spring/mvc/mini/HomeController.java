package spring.mvc.mini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spring.mvc.dao.MemberDao;

@Controller
public class HomeController {
  
	
	
	@GetMapping("/home")
	public String mainView()
	{
		//타일즈에서 지정한 레이아웃으로 출력
		//return "home.tiles";
		return "/layout/main";
	}
	
	
	
	@GetMapping("/shop/list")
	public String slist()
	{
		//return "list.tiles";
		return "/sub/myshop/shoplist";
	}
	
	//로그인폼
	@GetMapping("/login/form")
	public String loginform()
	{
		return "/login/loginmain";
	}
	
	
	
}
