package net.weg.wegproject.ConcreteClasses.order.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.order.exceptions.NoOrderException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.NoOrdersException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.OrderCreateException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.OrderUpdateException;
import net.weg.wegproject.ConcreteClasses.order.model.entity.OrderRequest;
import net.weg.wegproject.ConcreteClasses.order.model.entity.OrderRequestQuantity;
import net.weg.wegproject.ConcreteClasses.order.service.OrderService;
import net.weg.wegproject.ConcreteClasses.order.model.dto.OrderDTO;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class OrderController {

    OrderService orderService;
    CartService cartService;

    @Transactional
    @PostMapping("/{cartId}")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderdto, @PathVariable Long cartId) {
        try {
            Cart cart = cartService.findOne(cartId);

            if (cart == null) {
                return ResponseEntity.notFound().build();
            }

            OrderRequest order = new OrderRequest();
            BeanUtils.copyProperties(orderdto, order);

            List<OrderRequestQuantity> orderRequestQuantities = new ArrayList<>();

            for (CartProductQuantity cartProductQuantity : cart.getProducts()) {
                orderRequestQuantities.add(new OrderRequestQuantity(
                        cartProductQuantity.getProduct(),
                        order,
                        cartProductQuantity.getQuantity()
                ));
            }

            order.setProducts(orderRequestQuantities);

            ResponseEntity<?> response = orderService.createOrder(order);

            return response;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return orderService.findAll();
        }catch (Exception e){
            throw new NoOrdersException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        try {
            return orderService.findOne(id);
        }catch (Exception e){
            throw new NoOrderException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            return orderService.delete(id);
        }catch (Exception e){
            throw new OrderUpdateException();
        }
    }

}
