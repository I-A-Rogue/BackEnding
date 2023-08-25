package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories);

    @Query(value = "SELECT p from Product p, Automation a, Building b, Ink i, Motors m, Security s " +
            "WHERE LOWER(p.name) LIKE %:searchTerm% " +
            "AND ( :priceMin IS NULL OR :priceMin = 0 OR p.price >= ) " +
            "AND ( :priceMax IS NULL OR :priceMax = 9999999999 OR p.price <= ) " +
            "AND ( :type IS NULL OR :type = '' OR i.type =) " +
            "AND ( :color IS NULL OR :color = '' OR i.color =) " +
            "AND ( :density IS NULL OR :density = 0 OR i.density = )" +
            "AND ( :power IS NULL OR :power = 0 OR m.power = ) " +
            "AND ( :FrequenceMin IS NULL OR :FrequenceMin = 0 OR m.frequency >= ) " +
            "AND ( :FrequenceMax IS NULL OR :FrequenceMax = 9999999999 OR m.frequency <= ) " +

            "AND ( :carcass IS NULL OR :carcass = '' OR m.carcass = )" +

            "AND ( :rfi IS NULL OR :rfi = '' OR a.filterRFI = ) " +
            "AND ( :temperature IS NULL OR :temperature = 0 OR a.temperature = )" +


            "AND ( :plug IS NULL OR :plug = '' OR b.typeplug = ) " +
            "AND ( :battery IS NULL OR :battery = '' OR b.batterytype = ) " +
            "AND ( :casing IS NULL OR :casing = '' OR b.casing = )",
            nativeQuery = false)
    List<Product> searchBy(Pageable pageable,
                           String searchTerm,
                           Float priceMin,
                           Float priceMax,
                           String type,
                           String color,
                           Float density,
                           Float power,
                           Float FrequenceMin,
                           Float FrequenceMax,
                           String carcass,
                           String rfi,
                           Float temperature,
                           String plug,
                           String battery,
                           String casing);

    Page<Product> findAll(Pageable pageable);


}
