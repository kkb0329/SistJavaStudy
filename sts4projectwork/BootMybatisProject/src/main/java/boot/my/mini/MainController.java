package boot.my.mini;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Component({"boot.data.*","boot.my.mini"})
@Mapping
public class MainController {

	@GetMapping("/")
	public String goMain() {
		// TODO Auto-generated method stub

		return "main/mainpage";
	} 
	
	
	
}
