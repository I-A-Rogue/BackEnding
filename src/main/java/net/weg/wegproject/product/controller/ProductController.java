package net.weg.wegproject.product.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.ink.service.InkService;
import net.weg.wegproject.motors.service.MotorsService;
import net.weg.wegproject.product.model.entity.ProductFactory;
import net.weg.wegproject.product.service.ProductService;
import net.weg.wegproject.product.exceptions.*;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static net.weg.wegproject.categories.enuns.CategoriesEnums.TINTA;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    InkService inkService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO objDTO) {
            try {
                Product prod = new Product();
                BeanUtils.copyProperties(objDTO, prod);
                Product product = ProductFactory.criarProduto(objDTO);
                if(product instanceof Ink ink){
                    BeanUtils.copyProperties(prod, ink);
                    System.out.println(ink);
                    inkService.create(ink);
                    ink.setProduto(prod);
                    inkService.create(ink);
                }
                return ResponseEntity.ok(prod);
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
    }
    @GetMapping
    public ResponseEntity<List<Product>> findAllByCategories(@RequestParam CategoriesEnums categories) {
        try {
            System.out.println(categories);
//            List<Product> inks = new ArrayList<>();
            List<Product> produtos = productService.findAllByCategories(categories);
            System.out.println(produtos);
//            for (Product produto:produtos) {
//                inks.add(inkService.findOne(produto.getCode()));
//            }

            return ResponseEntity.ok().build();
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