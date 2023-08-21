package net.weg.wegproject.concreteClasses.cart.exceptions;

public class CartCreateException extends RuntimeException{
    public CartCreateException() {
        super("Não foi possivel criar este carrinho");
    }
}
