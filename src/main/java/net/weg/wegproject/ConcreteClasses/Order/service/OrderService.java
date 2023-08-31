package net.weg.wegproject.ConcreteClasses.Order.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.Order.model.entity.OrderRequest;
import net.weg.wegproject.ConcreteClasses.Order.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public ResponseEntity<OrderRequest> createOrder(OrderRequest order) {
        return ResponseEntity.ok(orderRepository.save(order));
    }

    public ResponseEntity<List<OrderRequest>> findAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    public ResponseEntity<OrderRequest> findOne(Long id) {
        return ResponseEntity.ok(orderRepository.findById(id).orElseThrow());
    }

    public ResponseEntity<OrderRequest> delete(Long id) {
        OrderRequest orderRequest = findOne(id).getBody();
                orderRepository.deleteById(id);
        return ResponseEntity.ok().body(orderRequest);
    }
}
