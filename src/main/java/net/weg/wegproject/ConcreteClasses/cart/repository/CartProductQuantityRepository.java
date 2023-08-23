package net.weg.wegproject.ConcreteClasses.cart.repository;

import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductQuantityRepository extends JpaRepository<CartProductQuantity, Long> {

    CartProductQuantity findByCartAndProduct(Cart cart, Product product);

}
