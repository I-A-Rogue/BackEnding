package net.weg.wegproject.ConcreteClasses.productsClasses.product.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.service.AutomationService;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.service.BuildingService;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.ProductFactory;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ink.service.InkService;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.service.MotorsService;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductsException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductDeleteException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductUpdateException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.service.SecurityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    InkService inkService;
    AutomationService automationService;
    MotorsService motorsService;
    BuildingService buildingService;
    SecurityService securityService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO objDTO) {
            try {
                Product prod = new Product();
                BeanUtils.copyProperties(objDTO, prod);
                Product product = ProductFactory.criarProduto(objDTO);
                manager(product, prod);
                return ResponseEntity.ok(prod);
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll(@RequestParam("size") int size,
                                                 @RequestParam("page") int page) {
        try {
            return ResponseEntity.ok(productService.findAll(PageRequest.of(page, size)));
        } catch (Exception e) {
            throw new NoProductsException();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllByCategories(@RequestParam CategoriesEnums categories,
                                                             @RequestParam("size") int size,
                                                             @RequestParam("page") int page) {
        try {
            return ResponseEntity.ok(productService.findAllByCategories(PageRequest.of(page, size), categories));
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

    private void manager(Product product, Product prod) {
        if(product instanceof Ink ink){
            BeanUtils.copyProperties(prod, ink);
            inkService.create(ink);
            ink.setProduto(prod);
            inkService.create(ink);
        }
        if(product instanceof Automation automation){
            BeanUtils.copyProperties(prod, automation);
            automationService.create(automation);
            automation.setProduto(prod);
            automationService.create(automation);
        }
        if(product instanceof Motors motors){
            BeanUtils.copyProperties(prod, motors);
            motorsService.create(motors);
            motors.setProduto(prod);
            motorsService.create(motors);
        }
        if(product instanceof Building building){
            BeanUtils.copyProperties(prod, building);
            buildingService.create(building);
            building.setProduto(prod);
            buildingService.create(building);
        }
        if(product instanceof Security security){
            BeanUtils.copyProperties(prod, security);
            securityService.create(security);
            security.setProduto(prod);
            securityService.create(security);
        }

    }
}