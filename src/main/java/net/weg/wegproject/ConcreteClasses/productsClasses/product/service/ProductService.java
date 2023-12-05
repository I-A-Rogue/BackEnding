package net.weg.wegproject.ConcreteClasses.productsClasses.product.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.projections.ProductResum;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductService{
    ProductRepository productRepository;

    public Product create(Product obj) {
        Assessment assessment = new Assessment();
        assessment.setAssessment(0);
        assessment.setTotalAssessment(0);
        assessment.setAmountVotes(0);
        obj.setAssessment(assessment);
        return productRepository.save(obj);
    }

    public void deleteALl(){
        productRepository.deleteAll();
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<ProductResum> buscarCard(){
        return productRepository.findAllMinimizado();
    }

    public List<ProductResum> buscarCardPorCategoria(Category category) {
        return productRepository.findByCategory(category);
    }

//    public List<ProductResum> filterProducts(Pageable pageable,
//                                             String searchTerm,
//                                             Float priceMin,
//                                             Float priceMax) {
//        System.out.println("Entrou no service: "+ searchTerm);
//        return productRepository.filterProducts(pageable, searchTerm, priceMin, priceMax);
//    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByCode(Long code) {
        try {
            return productRepository.findByCode(code);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Produto inexistente");
        }
    }

    public Product update(Product obj) {
        return productRepository.save(obj);
    }

    public Product delete(Long id) {
        Product product = findByCode(id);
        productRepository.delete(product);
        return product;
    }
}
