package net.weg.wegproject.ConcreteClasses.cart.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.exceptions.*;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.dto.CartDTO;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.cart.service.CartProductQuantityService;
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
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    CartService cartService;
    ProductService productService;
    CartProductQuantityService cartProductQuantityService;

    @PutMapping("/add/{cartId}/{productCode}")
    public ResponseEntity<Cart> addOnCart(
            @PathVariable Long cartId,
            @PathVariable Long productCode,
            @RequestParam Integer quantity
    ) {
        try {
            Cart cart = cartService.findOne(cartId);
            Product product = productService.findByCode(productCode);

            if (cart == null || product == null) {
                return ResponseEntity.notFound().build();
            }
            CartProductQuantity existingEntry = cartProductQuantityService.findByCartAndProduct(cart, product);

            Float productPrice = 0f;

            if (existingEntry != null) {
                existingEntry.setQuantity(quantity);
            } else {
                CartProductQuantity newEntry = new CartProductQuantity();
                newEntry.setCart(cart);
                newEntry.setProduct(product);
                newEntry.setQuantity(quantity);
                cart.getCartProductQuantities().add(newEntry);
            }

            for ( CartProductQuantity cartProductQuantity : cart.getCartProductQuantities() ) {
                productPrice += cartProductQuantity.getProduct().getPrice() * cartProductQuantity.getQuantity();
            }

            cart.setTotalPrice(productPrice);
            cart.setSize(cart.getCartProductQuantities().size());
            return ResponseEntity.ok(cartService.update(cart));
        } catch (CartCreateException | ExistingProductException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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

    @PutMapping("/remove/{cartId}/{productCode}")
    public ResponseEntity<Cart> deleteFromCart(@PathVariable Long cartId, @PathVariable Long productCode) {
        try {
            Cart cart = cartService.findOne(cartId);
            for ( CartProductQuantity cartProductQuantity : cart.getCartProductQuantities() ) {
                if (cartProductQuantity.getProduct().getCode().equals(productCode)) {
                    cart.setSize(cart.getCartProductQuantities().size() - 1);
                    cart.setTotalPrice(cart.getTotalPrice() - cartProductQuantity.getProduct().getPrice() * cartProductQuantity.getQuantity());
                    cart.getCartProductQuantities().remove(cartProductQuantity);
                    cartProductQuantityService.deleteByObject(cartProductQuantity);
                    break;
                }
            }
            return ResponseEntity.ok().body(cartService.update(cart));
        } catch (CartUpdateException | EmptyCartException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
