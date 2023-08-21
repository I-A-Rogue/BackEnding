package net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions;

public class NoProductException extends RuntimeException{
    public NoProductException() {
        super("Produto inexitente");
    }
}
