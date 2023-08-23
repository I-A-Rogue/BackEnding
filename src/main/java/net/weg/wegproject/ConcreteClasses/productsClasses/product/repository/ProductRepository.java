package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.enums.InkEnums;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories);

    Page<Product> findAll(Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.name) " +
            "LIKE %:searchTerm% ORDER BY p.assessment.amountVotes/p.assessment.assessment ASC"
            , nativeQuery = false)
    List<Product> searchBy(String searchTerm, Pageable pageable);

//    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.name) " +
//            "LIKE %:searchTerm% "+
//            "AND (:priceMin IS NULL OR p.price >= :priceMin) " +
//            "AND (:priceMax IS NULL OR p.price <= :priceMax) ",
//            nativeQuery = false)
//    List<Product> filterProducts(Pageable pageable,
//                                 String searchTerm,
//                                 @Param("priceMin") Float priceMin,
//                                 @Param("priceMax") Float priceMax);

    @Query(value = "SELECT * FROM Product p, Ink i " +
            "WHERE LOWER(p.name) LIKE %:searchTerm% " +
            "AND (:priceMin IS NULL OR p.price >= :priceMin) " +
            "AND (:priceMax IS NULL OR p.price <= :priceMax) " +
            "AND (:type IS NULL OR i.type = :type) " +
            "AND (:color IS NULL OR i.color = :color) " +
            "AND (:density IS NULL OR i.density = :density) " +
            "ORDER BY CASE WHEN :assessment = true THEN p.assessment.amountVotes / p.assessment.assessment END ASC, " +
            "CASE WHEN :assessment = false THEN p.assessment.amountVotes / p.assessment.assessment END DESC",
            nativeQuery = true)
    List<Product> filterProducts(Pageable pageable,
                                 String searchTerm,
                                 @Param("priceMin") Float priceMin,
                                 @Param("priceMax") Float priceMax,
                                 @Param("type") InkEnums type,
                                 @Param("color") String color,
                                 @Param("density") Integer density);


}
