package net.weg.wegproject.ink.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ink.exceptions.*;
import net.weg.wegproject.ink.model.InkDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ink.service.InkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/ink")
public class InkController {
    InkService inkService;
    @PostMapping
    public ResponseEntity<Ink> create(@RequestBody InkDTO objDTO) {
        try {
            try {
                Ink ink = new Ink();
                BeanUtils.copyProperties(objDTO, ink);
                return ResponseEntity.ok(inkService.create(ink));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new InkCreateException();
        }
    }
    @GetMapping
    public ResponseEntity<List<Ink>> findAll() {
        try {
            return ResponseEntity.ok(inkService.findAll());
        } catch (Exception e) {
            throw new NoInksException();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ink> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inkService.findOne(id));
        } catch (Exception e) {
            throw new NoInkException();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Ink> update(@RequestBody InkDTO objDTO, @PathVariable Long id) {
        try {
            try {

                Ink ink = inkService.findOne(id);
                BeanUtils.copyProperties(objDTO, ink);
                return ResponseEntity.ok(inkService.update(ink));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new InkUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Ink> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inkService.delete(id));
        } catch (Exception e) {
            throw new InkDeleteException();
        }
    }
}