package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class EmptyCartException extends RuntimeException{
    public EmptyCartException() {
        super("Carrinho esta vazio!");
    }
}
