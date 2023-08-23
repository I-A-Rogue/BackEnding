package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class CartCreateException extends RuntimeException{
    public CartCreateException() {
        super("Não foi possivel criar este carrinho");
    }
}
