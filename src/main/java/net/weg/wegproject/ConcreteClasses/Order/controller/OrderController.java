package net.weg.wegproject.ConcreteClasses.Order.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.Order.model.entity.OrderRequest;
import net.weg.wegproject.ConcreteClasses.Order.model.entity.OrderRequestQuantity;
import net.weg.wegproject.ConcreteClasses.Order.service.OrderService;
import net.weg.wegproject.ConcreteClasses.Order.model.dto.OrderDTO;
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
public class OrderController {

    OrderService orderService;
    CartService cartService;

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

            for (CartProductQuantity cartProductQuantity : cart.getCartProductQuantities()) {
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
        return orderService.findAll();
    }

}
