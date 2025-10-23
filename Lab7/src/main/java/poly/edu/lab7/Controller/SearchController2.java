package poly.edu.lab7.Controller;

import poly.edu.lab7.Dao.Bai5;
import poly.edu.lab7.Dao.ProductDAO;
import poly.edu.lab7.entity.Product;
import poly.edu.lab7.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class SearchController2 {

    @Autowired
    private Bai5 dao; // DAO bài 5, chứa method findAllByNameLike

    @Autowired
    private SessionService session;

    // Đổi URL riêng cho bài 5
    @RequestMapping("/product/search-bai5")
    public String searchAndPageBai5(Model model,
                                    @RequestParam("keywords") Optional<String> kw,
                                    @RequestParam("p") Optional<Integer> p) {

        // Lấy từ khóa từ tham số hoặc session
        String keywords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", keywords);

        // Số trang hiện tại (mặc định 0)
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        // Gọi DAO DSL để tìm kiếm sản phẩm
        Page<Product> page = dao.findAllByNameLike("%" + keywords + "%", pageable);

        // Gửi dữ liệu qua view
        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);

        return "search-bai5"; // template HTML riêng cho bài 5
    }
}
