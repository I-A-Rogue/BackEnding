package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p " +
            "FROM Product p " +
            "WHERE LOWER(p.name) LIKE %:searchTerm% " +
            "ORDER BY " +
            "CASE " +
            "    WHEN :priceDesc = TRUE THEN p.price END DESC, " +
            "CASE " +
            "    WHEN :priceAsc = TRUE THEN p.price END ASC")
    Page<Product> search(Pageable pageable,
                         String searchTerm,
                         Boolean priceDesc,
                         Boolean priceAsc);


    Page<Product> findAll(Pageable pageable);

    Product findByCode(Long code);


}
