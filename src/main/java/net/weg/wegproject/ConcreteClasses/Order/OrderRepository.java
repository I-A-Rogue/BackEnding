package net.weg.wegproject.ConcreteClasses.Order;

import net.weg.wegproject.ConcreteClasses.Order.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
}
