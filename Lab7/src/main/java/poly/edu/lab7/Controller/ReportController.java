package poly.edu.lab7.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.lab7.Dao.ProductDAO;
import poly.edu.lab7.Dao.ReportDao;
import poly.edu.lab7.entity.Report;

@Controller
public class ReportController {
    @Autowired
    ReportDao dao;

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "inventory";
    }
}
