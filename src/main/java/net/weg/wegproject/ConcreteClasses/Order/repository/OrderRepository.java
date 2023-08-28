package net.weg.wegproject.ConcreteClasses.Order.repository;

import net.weg.wegproject.ConcreteClasses.Order.model.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
}
