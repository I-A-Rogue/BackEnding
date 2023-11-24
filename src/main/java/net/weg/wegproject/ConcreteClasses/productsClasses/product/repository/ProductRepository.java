package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.projections.ProductResum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.code, p.price, p.image FROM Product p", nativeQuery = true)
    List<ProductResum> findAllMinimizado();
    Product findByCode(Long code);
}
