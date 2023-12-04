package net.weg.wegproject.ConcreteClasses.cart.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.exceptions.*;
import net.weg.wegproject.ConcreteClasses.cart.model.dto.CartDTO;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.cart.repository.CartProductQuantityRepository;
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
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/cart")
public class CartController {
    CartService cartService;
    ProductService productService;
    CartProductQuantityService cartProductQuantityService;
    CartProductQuantityRepository cartProductQuantityRepository;

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

            float productPrice = 0f;

            CartProductQuantity newEntry = new CartProductQuantity();
            if (existingEntry != null) {
                newEntry = existingEntry;
            } else {
                newEntry.setCart(cart);
                newEntry.setProduct(product);
            }
            newEntry.setQuantity(quantity);
            cart.getProducts().add(newEntry);

            cart.getProducts().remove(existingEntry);

            for ( CartProductQuantity cartProductQuantity : cart.getProducts() ) {
                if(cartProductQuantity.getProduct().getCode().equals(newEntry.getProduct().getCode())){
                    cartProductQuantity.setQuantity(quantity);
                }
                productPrice += cartProductQuantity.getProduct().getPrice() * cartProductQuantity.getQuantity();
            }

            cart.setTotalPrice(productPrice);
            cart.setSize(cart.getProducts().size());
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

    @Transactional
    @DeleteMapping("/remove/all/{cartId}")
    public ResponseEntity<Cart> deleteAllFromCart(@PathVariable Long cartId) {
        try {
            Cart cart = cartService.findOne(cartId);
            cart.setSize(0);
            cart.setTotalPrice(0f);
            List<CartProductQuantity> cartProductQuantities = cart.getProducts();
            cartProductQuantityRepository.deleteAll(cartProductQuantities);
            cart.getProducts().clear();
            cartService.update(cart);
            return ResponseEntity.ok().body(cart);
        } catch (CartUpdateException | EmptyCartException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @PutMapping("/remove/{cartId}/{productCode}")
    public ResponseEntity<Cart> deleteFromCart(@PathVariable Long cartId, @PathVariable Long productCode) {
        try {
            Cart cart = cartService.findOne(cartId);
            for ( CartProductQuantity cartProductQuantity : cart.getProducts() ) {
                if (cartProductQuantity.getProduct().getCode().equals(productCode)) {
                    cart.setSize(cart.getProducts().size() - 1);
                    cart.setTotalPrice(cart.getTotalPrice() - cartProductQuantity.getProduct().getPrice() * cartProductQuantity.getQuantity());
                    cart.getProducts().remove(cartProductQuantity);
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
