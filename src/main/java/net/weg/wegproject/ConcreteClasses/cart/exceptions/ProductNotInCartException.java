package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class ProductNotInCartException extends RuntimeException{
    public ProductNotInCartException() {
        super("Produto não esta no carrinho");
    }
}
