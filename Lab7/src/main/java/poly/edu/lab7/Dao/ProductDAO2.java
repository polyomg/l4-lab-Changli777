package poly.edu.lab7.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.lab7.entity.Product;

public interface ProductDAO2 extends JpaRepository<Product, Integer> {

    // DSL method với pageable
    Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);
}