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

    Page<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories);

    @Query(value = "SELECT p " +
            "FROM Product p " +
            "WHERE LOWER(p.name) LIKE %:searchTerm% ",
            nativeQuery = false)
            Page<Product> search(Pageable pageable,
                                            String searchTerm);

    @Query("SELECT m " +
            "FROM Motors m " +
            "WHERE (:priceMin IS NULL OR :priceMin = 0 OR m.product_motors.price > :priceMin) " +
            "AND (:priceMax IS NULL OR :priceMax = 99999999999 OR m.product_motors.price < :priceMax) " +
            "AND(:frequencyMin IS NULL OR :frequencyMin = 0 OR m.frequency >= :frequencyMin ) " +
            "AND (:frequencyMax IS NULL OR :frequencyMax = 9999999999 OR m.frequency <= :frequencyMax) " +
            "AND (:carcass IS NULL OR :carcass = '' OR m.carcass = :carcass) " +
            "AND (:material IS NULL OR :material = '' OR m.materialCarcass = :material)")
    Page<Product> filterMotors(
            Pageable pageable,
            @Param("priceMin") Float priceMin,
            @Param("priceMax") Float priceMax,
            @Param("frequencyMin") Float frequencyMin,
            @Param("frequencyMax") Float frequencyMax,
            @Param("carcass") String carcass,
            @Param("material") String material
    );

    @Query("SELECT i " +
            "FROM Ink i " +
            "WHERE (:priceMin IS NULL OR :priceMin = 0 OR i.product_ink.price > :priceMin) " +
            "AND (:priceMax IS NULL OR :priceMax = 99999999999 OR i.product_ink.price < :priceMax) " +
            "AND (:color IS NULL OR :color= '' OR i.color = :color) " +
            "AND (:density IS NULL OR :density = '' OR i.density = :density)")
    Page<Product> filterInk(
            Pageable pageable,
            @Param("priceMin") Float priceMin,
            @Param("priceMax") Float priceMax,
            @Param("color") String color,
            @Param("density") Float density
    );

    @Query("SELECT a " +
            "FROM Automation a " +
            "WHERE (:priceMin IS NULL OR :priceMin = 0 OR a.product_auto.price > :priceMin) " +
            "AND (:priceMax IS NULL OR :priceMax = 99999999999 OR a.product_auto.price < :priceMax) " +
            "AND (:voltage IS NULL OR :voltage = 0 OR a.nominalVoltageInput = :voltage) " +
            "AND (:rfi IS NULL OR :rfi = '' OR a.filterRFI = :rfi) " +
            "AND (:temperature IS NULL OR :temperature = 0 OR a.temperature = :temperature)")
    Page<Product> filterAutomation(
            Pageable pageable,
            @Param("priceMin") Float priceMin,
            @Param("priceMax") Float priceMax,
            @Param("voltage") Float voltage,
            @Param("rfi") String rfi,
            @Param("temperature") Float temperature
    );

    @Query("SELECT s " +
            "FROM Security s " +
            "WHERE (:priceMin IS NULL OR :priceMin = 0 OR s.product_security.price > :priceMin) " +
            "AND (:priceMax IS NULL OR :priceMax = 99999999999 OR s.product_security.price < :priceMax) " +
            "AND (:frequencyMin IS NULL OR :frequencyMin = 0 OR s.limitMinimumFrequency >= :frequencyMin ) " +
            "AND (:frequencyMax IS NULL OR :frequencyMax = 9999999999 OR s.limitMaximumFrequency <= :frequencyMax) " +
            "AND (:voltage IS NULL OR :voltage = 0 OR s.voltageCommand = :voltage)")
    Page<Product> filterSecurity(
            Pageable pageable,
            @Param("priceMin") Float priceMin,
            @Param("priceMax") Float priceMax,
            @Param("frequencyMin") Float frequencyMin,
            @Param("frequencyMax") Float frequencyMax,
            @Param("voltage") Float voltage
    );

@Query("SELECT b " +
            "FROM Building b " +
            "WHERE (:priceMin IS NULL OR :priceMin = 0 OR b.product_building.price > :priceMin) " +
            "AND (:priceMax IS NULL OR :priceMax = 99999999999 OR b.product_building.price < :priceMax) " +
            "AND (:plug IS NULL OR :plug = '' OR b.typeplug = :plug ) " +
            "AND (:battery IS NULL OR :battery = '' OR b.batterytype = :battery) " +
            "AND (:casing IS NULL OR :casing = '' OR b.casing = :casing)")
    Page<Product> filterBuilding(
            Pageable pageable,
            @Param("priceMin") Float priceMin,
            @Param("priceMax") Float priceMax,
            @Param("plug") String plug,
            @Param("battery") String battery,
            @Param("casing") String casing
    );


    Page<Product> findAll(Pageable pageable);

    Product findByCode(Long code);


}
