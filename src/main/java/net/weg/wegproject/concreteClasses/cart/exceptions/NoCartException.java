package net.weg.wegproject.concreteClasses.cart.exceptions;

public class NoCartException extends RuntimeException{
    public NoCartException() {
        super("carrinho inexitente");
    }
}
