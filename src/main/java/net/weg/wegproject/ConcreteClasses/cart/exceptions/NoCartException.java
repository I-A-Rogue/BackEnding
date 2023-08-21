package net.weg.wegproject.cart.exceptions;

public class NoCartException extends RuntimeException{
    public NoCartException() {
        super("carrinho inexitente");
    }
}
