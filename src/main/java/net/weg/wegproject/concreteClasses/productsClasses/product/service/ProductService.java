package net.weg.wegproject.concreteClasses.productsClasses.product.service;

import lombok.AllArgsConstructor;
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/product/service/ProductService.java
import net.weg.wegproject.product.repository.ProductRepository;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.interfeces.ServiceInterface;
=======
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.concreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Pageable;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/product/service/ProductService.java
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductService implements ServiceInterface<Product> {
    ProductRepository productRepository;

    @Override
    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        try {
            return productRepository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Produto inexistente");
        }
    }

    @Override
    public Product update(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Product delete(Long id) {
        Product product = findOne(id);
        productRepository.delete(product);
        return product;
    }
}
