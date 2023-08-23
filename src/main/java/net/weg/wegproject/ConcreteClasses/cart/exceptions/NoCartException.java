package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class NoCartException extends RuntimeException{
    public NoCartException() {
        super("carrinho inexitente");
    }
}
