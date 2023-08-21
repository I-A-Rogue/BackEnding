package net.weg.wegproject.ConcreteClasses.productsClasses.motors.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions.*;
import net.weg.wegproject.motors.exceptions.*;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.service.MotorsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/motors")
public class MotorsController {
    MotorsService motorsService;

    @PostMapping
    public ResponseEntity<Motors> create(@RequestBody MotorsDTO objDTO) {
        try {
            try {
                Motors motors = new Motors();
                BeanUtils.copyProperties(objDTO, motors);
                return ResponseEntity.ok(motorsService.create(motors));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new MotorCreateException();
        }
    }
    @GetMapping
    public ResponseEntity<List<Motors>> findAll() {
        try {
            return ResponseEntity.ok(motorsService.findAll());
        } catch (Exception e) {
            throw new NoMotorsException();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Motors> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(motorsService.findOne(id));
        } catch (Exception e) {
            throw new NoMotorException();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Motors> update(@RequestBody MotorsDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Motors motors = motorsService.findOne(id);
                BeanUtils.copyProperties(objDTO, motors);
                return ResponseEntity.ok(motorsService.update(motors));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new MotorUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Motors> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(motorsService.delete(id));
        } catch (Exception e) {
            throw new MotorDeleteException();
        }
    }
}