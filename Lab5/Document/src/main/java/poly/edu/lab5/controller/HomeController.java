package poly.edu.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // lấy username trong session (nếu có)
        model.addAttribute("title", "Trang chủ");
        return "home"; // trả về file templates/home.html
    }
}