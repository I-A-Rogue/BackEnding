package net.weg.wegproject.product.repository;

import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories(CategoriesEnums categories);

}
