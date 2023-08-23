package net.weg.wegproject.ConcreteClasses.cart.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.repository.CartRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CartService implements ServiceInterface<Cart> {
    CartRepository cartRepository;

    @Override
    public Cart create(Cart obj) {
        return cartRepository.save(obj);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findOne(Long id) {
        try {
            return cartRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Carrinho não encontrado");
        }
    }

    @Override
    public Cart update(Cart obj) {
        return cartRepository.save(obj);
    }

    @Override
    public Cart delete(Long id) {
        Cart cart = this.findOne(id);
        cartRepository.delete(cart);
        return cart;
    }
}
