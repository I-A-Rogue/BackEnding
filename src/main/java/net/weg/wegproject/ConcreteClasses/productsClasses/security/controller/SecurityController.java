package net.weg.wegproject.ConcreteClasses.productsClasses.security.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.exceptions.*;
import net.weg.wegproject.security.dto.SecurityDTO;
import net.weg.wegproject.security.exceptions.*;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.service.SecurityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/security")
public class SecurityController {
    SecurityService securityService;

    @PostMapping
    public ResponseEntity<Security> create(@RequestBody SecurityDTO objDTO) {
        try {
            try {
                Security security = new Security();
                BeanUtils.copyProperties(objDTO, security);
                return ResponseEntity.ok(securityService.create(security));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new SecurityCreateException();
        }
    }
    @GetMapping
    public ResponseEntity<List<Security>> findAll() {
        try {
            return ResponseEntity.ok(securityService.findAll());
        } catch (Exception e) {
            throw new NoSecuritysException();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Security> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(securityService.findOne(id));
        } catch (Exception e) {
            throw new NoSecurityException();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Security> update(@RequestBody SecurityDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Security security = securityService.findOne(id);
                BeanUtils.copyProperties(objDTO, security);
                return ResponseEntity.ok(securityService.update(security));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new SecurityUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Security> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(securityService.delete(id));
        } catch (Exception e) {
            throw new SecurityDeleteException();
        }
    }
}
