package spring.mvc.coffee;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dto.InfoDto;

@Controller
public class InfoController {

    // index ¡æ redirect to form
	

    // Æû ÆäÀÌÁö Ç¥½Ã
    @GetMapping("/info/myform")
    public String showForm() {
        return "/info/infoform"; // ¡æ /WEB-INF/info/infoform.jsp
    }

    // Æû Ã³¸®
    @PostMapping("/info/result")
    public String processForm(@ModelAttribute InfoDto dto, Model model) {
        model.addAttribute("dto", dto);
        return "/info/infowrite"; // ¡æ /WEB-INF/info/infowrite.jsp
    }
}
	
	
	
	
	

