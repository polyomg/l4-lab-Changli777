package poly.edu.lab7.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.lab7.entity.Product;

public interface Bai5 extends JpaRepository<Product, Integer> {

    // DSL method thay cho @Query
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}
