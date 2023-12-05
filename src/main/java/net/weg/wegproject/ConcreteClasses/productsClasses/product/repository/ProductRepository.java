package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.projections.ProductResum;
import net.weg.wegproject.enums.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.code, p.model, p.price, p.category, p.image, p.protection FROM Product p", nativeQuery = true)
    List<ProductResum> findAllMinimizado();
    Product findByCode(Long code);

    List<ProductResum> findByCategory(Category category);

//        @Query(value = "SELECT p FROM Product p " +
//            "WHERE LOWER(p.name) LIKE %:searchTerm% "+
//            "AND (:priceMin IS NULL OR p.price = 0 OR p.price >= :priceMin) " +
//            "AND (:priceMax IS NULL OR p.price = 999999999 OR p.price <= :priceMax) " +
//            "ORDER BY CASE WHEN :assessment = true THEN p.assessment.amountVotes / p.assessment.assessment END ASC, +\n" +
//            "CASE WHEN :assessment = false THEN p.assessment.amountVotes / p.assessment.assessment END DESC",
//            nativeQuery = false)
//    List<Product> filterProducts(Pageable pageable,
//                                 String searchTerm,
//                                 @Param("priceMin") Float priceMin,
//                                 @Param("priceMax") Float priceMax,
//                                 @Param("assessment") Boolean assessment);


//    @Query("SELECT p " +
//            "FROM Product p " +
//            "WHERE p.motors.model LIKE %:searchTerm% " +
//            "AND (:priceMin IS NULL OR p.price >= :priceMin ) " +
//            "AND (:priceMax IS NULL OR p.price <= :priceMax ) ")
//    List<ProductResum> filterProducts(Pageable pageable,
//                                      String searchTerm,
//                                      @Param("priceMin") Float priceMin,
//                                      @Param("priceMax") Float priceMax);
}
