package net.weg.wegproject.ConcreteClasses.cart.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.exceptions.*;
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
        try {
            return cartRepository.save(obj);
        }catch (Exception e){
            throw new CartCreateException();
        }
    }

    @Override
    public List<Cart> findAll() {
        try {
            return cartRepository.findAll();
        } catch (Exception e) {
            throw new NoCartsException();
        }
    }

    @Override
    public Cart findOne(Long id) {
        try {
            return cartRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NoCartException();
        }
    }

    @Override
    public Cart update(Cart obj) {
        try {
            return cartRepository.save(obj);
        } catch (Exception e) {
            throw new CartUpdateException();
        }
    }

    @Override
    public Cart delete(Long id) {
        try {
            Cart cart = this.findOne(id);
            cartRepository.delete(cart);
            return cart;
        }catch (Exception e){
            throw new CartDeleteException();
        }
    }
}
