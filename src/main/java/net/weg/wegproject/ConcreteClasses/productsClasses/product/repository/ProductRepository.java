package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories);

//    @Query(value = "SELECT p FROM Product p " +
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


    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE LOWER(p.name) LIKE %:searchTerm% " +
            "AND (:priceMin IS NULL OR p.price >= :priceMin ) " +
            "AND (:priceMax IS NULL OR p.price <= :priceMax ) ")
            List<Product> filterProducts(Pageable pageable,
                                            String searchTerm,
                                            @Param("priceMin") Float priceMin,
                                            @Param("priceMax") Float priceMax);


    @Query("SELECT m " +
            "FROM Motors m " +
            "WHERE (:frequencyMin IS NULL OR :frequencyMin = 0 OR m.frequency >= :frequencyMin ) " +
            "AND (:frequencyMax IS NULL OR :frequencyMax = 9999999999 OR m.frequency <= :frequencyMax) " +
            "AND (:carcass IS NULL OR :carcass = '' OR m.carcass = :carcass) " +
            "AND (:material IS NULL OR :material = '' OR m.materialCarcass = :material)")
    List<Product> filterMotors(
            @Param("frequencyMin") Float frequencyMin,
            @Param("frequencyMax") Float frequencyMax,
            @Param("carcass") String carcass,
            @Param("material") String material
    );

    @Query("SELECT i " +
            "FROM Ink i " +
            "WHERE (:color IS NULL OR :color= '' OR i.color = :color) " +
            "AND (:density IS NULL OR :density = '' OR i.density = :density)")
    List<Product> filterInk(
            @Param("color") String color,
            @Param("density") Float density
    );

    @Query("SELECT a " +
            "FROM Automation a " +
            "WHERE (:voltage IS NULL OR :voltage = 0 OR a.nominalVoltageInput = :voltage) " +
            "AND (:rfi IS NULL OR :rfi = '' OR a.filterRFI = :rfi) " +
            "AND (:temperature IS NULL OR :temperature = 0 OR a.temperature = :temperature)")
    List<Product> filterAutomation(
            @Param("voltage") Float voltage,
            @Param("rfi") String rfi,
            @Param("temperature") Float temperature
    );

    @Query("SELECT s " +
            "FROM Security s " +
            "WHERE (:frequencyMin IS NULL OR :frequencyMin = 0 OR s.limitMinimumFrequency >= :frequencyMin ) " +
            "AND (:frequencyMax IS NULL OR :frequencyMax = 9999999999 OR s.limitMaximumFrequency <= :frequencyMax) " +
            "AND (:voltage IS NULL OR :voltage = 0 OR s.voltageCommand = :voltage)")
    List<Product> filterSecurity(
            @Param("frequencyMin") Float frequencyMin,
            @Param("frequencyMax") Float frequencyMax,
            @Param("voltage") Float voltage
    );

@Query("SELECT b " +
            "FROM Building b " +
            "WHERE (:plug IS NULL OR :plug = '' OR b.typeplug = :plug ) " +
            "AND (:battery IS NULL OR :battery = '' OR b.batterytype = :battery) " +
            "AND (:casing IS NULL OR :casing = '' OR b.casing = :casing)")
    List<Product> filterBuilding(
            @Param("plug") String plug,
            @Param("battery") String battery,
            @Param("casing") String casing
    );


    Page<Product> findAll(Pageable pageable);


}
