package net.weg.wegproject.ConcreteClasses.order.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.order.exceptions.NoOrderException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.NoOrdersException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.OrderCreateException;
import net.weg.wegproject.ConcreteClasses.order.exceptions.OrderDeleteException;
import net.weg.wegproject.ConcreteClasses.order.model.entity.OrderRequest;
import net.weg.wegproject.ConcreteClasses.order.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public ResponseEntity<OrderRequest> createOrder(OrderRequest order) {
        try {
            return ResponseEntity.ok(orderRepository.save(order));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ResponseEntity<List<OrderRequest>> findAll() {
        try {
            return ResponseEntity.ok(orderRepository.findAll());
        }catch (Exception e){
            throw new NoOrdersException();
        }
    }

    public ResponseEntity<OrderRequest> findOne(Long id) {
        try {
            return ResponseEntity.ok(orderRepository.findById(id).orElseThrow());
        }catch (Exception e){
            throw new NoOrderException();
        }
    }

    public ResponseEntity<OrderRequest> delete(Long id) {
        try {
            OrderRequest orderRequest = findOne(id).getBody();
            orderRepository.deleteById(id);
            return ResponseEntity.ok().body(orderRequest);
        }catch (Exception e ){
            throw new OrderDeleteException();
        }
    }
}
