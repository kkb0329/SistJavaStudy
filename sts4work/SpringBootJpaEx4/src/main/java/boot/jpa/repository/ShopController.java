package boot.jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import boot.jpa.dto.ShopDao;
import boot.jpa.dto.ShopDto;

@Controller
@RequestMapping("/food")
public class ShopController {

    @Autowired
    private ShopDao dao;

    // 👉 폼 페이지
    @GetMapping("/form")
    public String form(Model model) {
        String[] images = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg"};
        model.addAttribute("images", images);
        return "food/form"; // => /WEB-INF/food/form.jsp
    }

    // 👉 저장
    @PostMapping("/insert")
    public String insert(@ModelAttribute ShopDto dto) {
        dao.insertShop(dto);
        return "redirect:/food/list";
    }

    // 👉 목록
    @GetMapping({"/list", "/"})
    public String list(Model model) {
        List<ShopDto> list = dao.getAllDatas();
        model.addAttribute("list", list);
        model.addAttribute("count", list.size());
        return "food/list"; // => /WEB-INF/food/list.jsp
    }

    // 👉 수정 폼
    @GetMapping("/updateform")
    public String updateForm(@RequestParam int num, Model model) {
        ShopDto dto = dao.getData(num);
        model.addAttribute("dto", dto);
        return "food/updateform"; // => /WEB-INF/food/updateform.jsp
    }

    // 👉 수정 처리
    @PostMapping("/update")
    public String update(@ModelAttribute ShopDto dto) {
        dao.updateShop(dto);
        return "redirect:/food/list";
    }

    // 👉 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam int num) {
        dao.deleteShop(num);
        return "redirect:/food/list";
    }
}
