package net.weg.wegproject.concreteClasses.productsClasses.product.exceptions;

public class NoProductException extends RuntimeException{
    public NoProductException() {
        super("Produto inexitente");
    }
}
