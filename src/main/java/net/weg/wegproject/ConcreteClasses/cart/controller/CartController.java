package net.weg.wegproject.ConcreteClasses.cart.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.exceptions.*;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.dto.CartDTO;
import net.weg.wegproject.ConcreteClasses.cart.service.CartService;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
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
    ProductService productService;

    @PutMapping("add/{cartId}/{productCode}")
    public ResponseEntity<Cart> addOnCart(@PathVariable Long cartId, @PathVariable Long productCode) {
        try {
            try {
                Cart cart = findOne(cartId).getBody();
                Product product = productService.findOne(productCode);
                if (cart != null) {
                    cart.setSize(cart.getSize() + 1);
                    cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
                        if(!cart.getProducts().contains(product)) {
                            cart.getProducts().add(product);
                        } else {
                            throw new ExistingProductException();
                        }
                }
                return ResponseEntity.ok(cartService.update(cart));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (CartCreateException | ExistingProductException u) {
            throw new RuntimeException(u.getMessage());
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

    @PutMapping("remove/{cartId}/{productCode}")
    public ResponseEntity<Cart> deleteFromCart(@PathVariable Long cartId, @PathVariable Long productCode) {
        try {
            Cart cart = findOne(cartId).getBody();
            Product product = productService.findOne(productCode);
            try{
                if (cart != null && cart.getSize() > 0) {
                    if(cart.getProducts().contains(product)){
                        cart.setSize(cart.getSize() - 1);
                        cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
                        cart.getProducts().remove(product);
                    }else {
                        throw new ProductNotInCartException();
                    }
                }else{
                    throw new EmptyCartException();
                }
            } catch (EmptyCartException | ProductNotInCartException e){
                throw new RuntimeException(e.getMessage());
            }

            return ResponseEntity.ok().body(cartService.update(cart));
        } catch (CartUpdateException | EmptyCartException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
