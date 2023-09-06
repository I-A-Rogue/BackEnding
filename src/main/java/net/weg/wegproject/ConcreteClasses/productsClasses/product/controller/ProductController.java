package net.weg.wegproject.ConcreteClasses.productsClasses.product.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.FiltroDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Filtro;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.ProductFactory;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.NoProductsException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductDeleteException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions.ProductUpdateException;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
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
            try {
                Product prod = new Product();
                BeanUtils.copyProperties(objDTO, prod);
                Product product = ProductFactory.criarProduto(objDTO);
                BeanUtils.copyProperties(prod, product);
                Assessment assessment = new Assessment();
                assessment.setAssessment(0);
                assessment.setTotalAssessment(0);
                assessment.setAmountVotes(0);
                product.setAssessment(assessment);
                Product productCreated = productService.create(product);
                return ResponseEntity.ok(productCreated);
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
    }
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@RequestParam("size") int size,
                                        @RequestParam("page") int page) {
        try {
            return ResponseEntity.ok(productService.findAll(PageRequest.of(page, size)));
        } catch (Exception e) {
            throw new NoProductsException();
        }
    }

        @GetMapping("/search/{searchTerm}")
    public ResponseEntity<Page<Product>> searchBy(@PathVariable String searchTerm,
                                                  @ModelAttribute FiltroDTO filtroDTO,
                                                  @RequestParam("size") int size,
                                                  @RequestParam("page") int page) {
            Filtro filtro = new Filtro();
            BeanUtils.copyProperties(filtroDTO, filtro);
            return ResponseEntity.ok(productService.searchBy(PageRequest.of(page, size), searchTerm, filtro));
    }

    @GetMapping("/product/{categories}")
    public ResponseEntity<Page<Product>> searchByCategories(@PathVariable CategoriesEnums categories,
                                                        @ModelAttribute FiltroDTO filtroDTO,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("page") int page) {
            Filtro filtro = new Filtro();
            BeanUtils.copyProperties(filtroDTO, filtro);
            switch (categories) {
                case MOTORS -> {
                    return ResponseEntity.ok(productService.buscarCategoriaMotor(PageRequest.of(page, size), filtro));
                }
                case INK -> {
                    return ResponseEntity.ok(productService.buscarCategoriaInk(PageRequest.of(page, size), filtro));
                }
                case AUTOMATION -> {
                    return ResponseEntity.ok(productService.buscarCategoriaAutomation(PageRequest.of(page, size), filtro));
                }
                case BUILDING -> {
                    return ResponseEntity.ok(productService.buscarCategoriaBuilding(PageRequest.of(page, size), filtro));
                }
                case SECURITY -> {
                    return ResponseEntity.ok(productService.buscarCategoriaSecurity(PageRequest.of(page, size), filtro));
                }
                default -> throw new RuntimeException("Categoria inválida");
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

    @GetMapping("/category")
    public ResponseEntity<Page<Product>> findAllByCategories(@RequestParam CategoriesEnums categories,
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