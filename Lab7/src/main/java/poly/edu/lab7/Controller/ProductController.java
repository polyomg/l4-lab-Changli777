package poly.edu.lab7.Controller;

import poly.edu.lab7.Dao.ProductDAO;
import poly.edu.lab7.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        model.addAttribute("param", Map.of("min", minPrice, "max", maxPrice));
        return "search";
    }
}
