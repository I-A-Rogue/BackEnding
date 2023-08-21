package net.weg.wegproject.product.repository;

import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.categories = :categories")
    List<Product> findAllByCategories(CategoriesEnums categories);

}
