package net.weg.wegproject.categories.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.categories.model.dto.CategoriesDTO;
import net.weg.wegproject.categories.service.CategoriesService;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.categories.exceptions.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categories/")
public class CategoriesController {
    CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<Categories> create(@RequestBody CategoriesDTO objDTO) {
        try {
            try {
                Categories categories = new Categories();
                BeanUtils.copyProperties(objDTO, categories);
                return ResponseEntity.ok(categoriesService.create(categories));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            throw new CategorieCreateException();
        }
    }

    @GetMapping
    public ResponseEntity<List<Categories>> findAll() {
        try {
            return ResponseEntity.ok(categoriesService.findAll());
        } catch (Exception e) {
            throw new NoCategoriesException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoriesService.findOne(id));
        } catch (Exception e) {
            throw new NoCategorieException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categories> update(@RequestBody CategoriesDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Categories categories = categoriesService.findOne(id);
                BeanUtils.copyProperties(objDTO, categories);
                return ResponseEntity.ok(categoriesService.update(categories));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            throw new CategorieUpdateException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categories> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoriesService.delete(id));
        } catch (Exception e) {
            throw new CategorieDeleteException();
        }
    }
}