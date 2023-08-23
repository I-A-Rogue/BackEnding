package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class ExistingProductException extends RuntimeException{
    public ExistingProductException() {
        super("Produto já adicionado");
    }

}
