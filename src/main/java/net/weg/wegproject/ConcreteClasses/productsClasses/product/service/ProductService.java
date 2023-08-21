package net.weg.wegproject.ConcreteClasses.productsClasses.product.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductService{
    ProductRepository productRepository;

    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    public List<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories){
        return productRepository.findAllByCategories(pageable, categories);
    }

    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        try {
            return productRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Produto inexistente");
        }
    }

    public Product update(Product obj) {
        return productRepository.save(obj);
    }

    public Product delete(Long id) {
        Product product = findOne(id);
        productRepository.delete(product);
        return product;
    }
}
