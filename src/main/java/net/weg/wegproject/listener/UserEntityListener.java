package net.weg.wegproject.listener;


import jakarta.persistence.PostPersist;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

public class UserEntityListener {

    @PostPersist
    public void afterPersist(User usuario) {
        Cart carrinho = new Cart(usuario);
        Saves saves = new Saves(usuario);
        usuario.setSaves(saves);
        usuario.setCart(carrinho);
    }
}