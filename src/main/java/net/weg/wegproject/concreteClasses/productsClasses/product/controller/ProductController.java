package net.weg.wegproject.concreteClasses.productsClasses.product.controller;

import lombok.AllArgsConstructor;
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/product/controller/ProductController.java
import net.weg.wegproject.product.model.entity.ProductFactory;
import net.weg.wegproject.product.service.ProductService;
import net.weg.wegproject.product.exceptions.*;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
=======
import net.weg.wegproject.concreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.concreteClasses.productsClasses.automation.service.AutomationService;
import net.weg.wegproject.concreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.concreteClasses.productsClasses.building.service.BuildingService;
import net.weg.wegproject.concreteClasses.productsClasses.ink.service.InkService;
import net.weg.wegproject.concreteClasses.productsClasses.motors.service.MotorsService;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.ProductFactory;
import net.weg.wegproject.concreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.concreteClasses.productsClasses.product.exceptions.ProductDeleteException;
import net.weg.wegproject.concreteClasses.productsClasses.product.exceptions.ProductUpdateException;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.concreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.concreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.concreteClasses.productsClasses.product.exceptions.NoProductException;
import net.weg.wegproject.concreteClasses.productsClasses.product.exceptions.NoProductsException;
import net.weg.wegproject.concreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.concreteClasses.productsClasses.security.service.SecurityService;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/product/controller/ProductController.java
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO objDTO) {
        try {
            try {
                Product product = new Product();
                BeanUtils.copyProperties(objDTO, product);
                System.out.println(product);
                System.out.println(ProductFactory.createProduct(ResponseEntity.ok(productService.create(product)).getBody()).getClass());
                return ResponseEntity.ok(productService.create(product));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new ProductCreateException();
        }
    }
    @GetMapping
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
            return ResponseEntity.ok(productService.findOne(id));
        } catch (Exception e) {
            throw new NoProductException();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Product product = productService.findOne(id);
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