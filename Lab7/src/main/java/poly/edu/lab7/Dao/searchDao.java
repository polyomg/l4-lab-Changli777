package poly.edu.lab7.Dao;

import poly.edu.lab7.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  searchDao extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);
    // CAST(p.id AS string)

}