package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Filtro;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.projections.ProductResum;
import net.weg.wegproject.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.code, p.model, p.price, p.category, p.image, p.protection FROM Product p", nativeQuery = true)
    List<ProductResum> findAllMinimizado();
    Product findByCode(Long code);

    List<ProductResum> findByCategory(Category category);

//    @Query(value = "SELECT p.code, p.price, p.image FROM Product p WHERE p.name LIKE %?1%")
//    List<ProductResum> findByFilter(String searchText, Filtro filtro);

}
