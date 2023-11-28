package net.weg.wegproject.listener;


import jakarta.persistence.PostPersist;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.security.model.Profile;

import java.util.List;

public class UserEntityListener {

    @PostPersist
    public void afterPersist(User usuario) {
        Cart carrinho = new Cart(usuario);
        Saves saves = new Saves(usuario);
        usuario.setEnabled(true);
        usuario.setAccountNonLocked(true);
        usuario.setAccountNonExpired(true);
        usuario.setCredentialsNonExpired(true);
        usuario.setSaves(saves);
        usuario.setCart(carrinho);
    }
}