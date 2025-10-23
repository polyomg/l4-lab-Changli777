package poly.edu.lab7.Controller;

import poly.edu.lab7.Dao.ProductDAO2;
import poly.edu.lab7.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ProductController2 {
    @Autowired
    private ProductDAO2 dao;

    @RequestMapping("/product/search-price")
    public String searchByPrice(Model model,
                                @RequestParam(name = "minPrice", required = false) Double minPrice,
                                @RequestParam(name = "maxPrice", required = false) Double maxPrice,
                                @RequestParam(name = "p", required = false) Integer page) {

        double min = minPrice != null ? minPrice : 0.0;
        double max = maxPrice != null ? maxPrice : 1000000.0; // giá tối đa hợp lý

        int currentPage = page != null ? page : 0;
        Pageable pageable = PageRequest.of(currentPage, 5);

        Page<Product> resultPage = dao.findByPriceBetween(min, max, pageable);

        model.addAttribute("page", resultPage);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        return "search-price";
    }
}
