package poly.edu.lab7.Controller;

import poly.edu.lab7.Dao.searchDao;
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
public class SearchController {
    @Autowired
    searchDao dao;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        // Lấy từ khóa từ tham số hoặc session
        String keywords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", keywords);

        // Số trang hiện tại (mặc định 0)
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        // Gọi DAO để tìm kiếm sản phẩm
        Page<Product> page = dao.findByKeywords("%" + keywords + "%", pageable);

        // Gửi dữ liệu qua view
        model.addAttribute("page", page);
        return "page";
    }

}
