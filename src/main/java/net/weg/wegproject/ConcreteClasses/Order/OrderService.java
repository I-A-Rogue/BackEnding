package net.weg.wegproject.ConcreteClasses.Order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public ResponseEntity<?> createOrder(OrderRequest order) {
        return ResponseEntity.ok(orderRepository.save(order));
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }
}
