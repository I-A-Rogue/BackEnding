package net.weg.wegproject.cart.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.cart.model.entity.Cart;
import net.weg.wegproject.cart.model.dto.CartDTO;
import net.weg.wegproject.cart.exceptions.CartCreateException;
import net.weg.wegproject.cart.exceptions.CartUpdateException;
import net.weg.wegproject.cart.exceptions.NoCartException;
import net.weg.wegproject.cart.exceptions.NoCartsException;
import net.weg.wegproject.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartDTO objDTO) {
        try {
            try {
                Cart cart = new Cart();
                BeanUtils.copyProperties(objDTO, cart);
                return ResponseEntity.ok(cartService.create(cart));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new CartCreateException();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        try {
            return ResponseEntity.ok(cartService.findAll());
        } catch (Exception e) {
            throw new NoCartsException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(cartService.findOne(id));
        } catch (Exception e) {
            throw new NoCartException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cart> update(@RequestBody CartDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Cart cart = cartService.findOne(id);
                BeanUtils.copyProperties(objDTO, cart);
                return ResponseEntity.ok(cartService.update(cart));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new CartUpdateException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cart> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(cartService.delete(id));
        } catch (Exception e) {
            throw new CartUpdateException();
        }
    }
}
