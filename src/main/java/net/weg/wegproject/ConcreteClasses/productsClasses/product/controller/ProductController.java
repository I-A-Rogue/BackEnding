package net.weg.wegproject.ConcreteClasses.productsClasses.product.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.projections.ProductResum;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductsException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductDeleteException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductUpdateException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO objDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(objDTO, product);
        Assessment assessment = new Assessment();
        assessment.setAssessment(0);
        assessment.setTotalAssessment(0);
        assessment.setAmountVotes(0);
        product.setAssessment(assessment);
        return ResponseEntity.ok(productService.create(product));

    }
    @GetMapping("/completo")
    public ResponseEntity<Page<Product>> findAll(@RequestParam("size") int size,
                                        @RequestParam("page") int page) {
        try {
            return ResponseEntity.ok(productService.findAll(PageRequest.of(page, size)));
        } catch (Exception e) {
            throw new NoProductsException();
        }
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<ProductResum>> buscarCard(
            @RequestParam("size") int size,
            @RequestParam("page") int page
    ){
        try {
            return ResponseEntity.ok(productService.buscarCard());
        }catch (Exception e){
            throw new NoProductsException();
        }
    }

    @GetMapping("/resumo/{category}")
    public ResponseEntity<List<ProductResum>> buscarCardPorCategoria(
            @PathVariable Category category,
            @RequestParam("size") int size,
            @RequestParam("page") int page
    ){
        try {
            return ResponseEntity.ok(productService.buscarCardPorCategoria(category));
        }catch (Exception e){
            throw new NoProductsException();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        try {
            return ResponseEntity.ok(productService.findAll());
        } catch (Exception e) {
            throw new NoProductsException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.findByCode(id));
        } catch (Exception e) {
            throw new NoProductException();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Product product = productService.findByCode(id);
                BeanUtils.copyProperties(objDTO, product);
                return ResponseEntity.ok(productService.update(product));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new ProductUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.delete(id));
        } catch (Exception e) {
            throw new ProductDeleteException();
        }
    }

}