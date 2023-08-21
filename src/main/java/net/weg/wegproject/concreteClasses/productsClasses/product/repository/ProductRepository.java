package net.weg.wegproject.concreteClasses.productsClasses.product.repository;

<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/product/repository/ProductRepository.java
import net.weg.wegproject.product.model.entity.Product;
=======
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Pageable;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/product/repository/ProductRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
