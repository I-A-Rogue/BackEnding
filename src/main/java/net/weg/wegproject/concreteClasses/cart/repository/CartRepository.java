package net.weg.wegproject.concreteClasses.cart.repository;

import net.weg.wegproject.concreteClasses.cart.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
