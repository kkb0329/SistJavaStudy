package boot.data.controller;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

	@GetMapping("/form1")
	public String form1()
	{
		return "form/form1";
	}
	
	@GetMapping("/form2")
	public String form2()
	{
		return "form/form2";
	}
	
	@GetMapping("/form3")
	public String form3()
	{
		return "form/form3";
	}
}
