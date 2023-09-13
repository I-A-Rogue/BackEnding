package net.weg.wegproject.ConcreteClasses.cart.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.cart.repository.CartProductQuantityRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartProductQuantityService implements ServiceInterface<CartProductQuantity> {

    CartProductQuantityRepository cartProductQuantityRepository;

    public CartProductQuantity findByCartAndProduct(Cart cart, Product product) {
        return cartProductQuantityRepository.findByCartAndProduct(cart, product);
    }

    @Override
    public CartProductQuantity create(CartProductQuantity obj) {
        return null;
    }

    @Override
    public List<CartProductQuantity> findAll() {
        return null;
    }

    @Override
    public CartProductQuantity findOne(Long id) {
        return null;
    }

    @Override
    public CartProductQuantity update(CartProductQuantity obj) {
        return null;
    }

    @Override
    public CartProductQuantity delete(Long id) {
        return null;
    }



    public CartProductQuantity deleteByObject(CartProductQuantity obj) {
        cartProductQuantityRepository.delete(obj);
        return obj;
    }
}