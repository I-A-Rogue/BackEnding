package net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions;

public class NoProductsException extends RuntimeException{
    public NoProductsException() {
        super("Não exite nenhum produto cadastrada");
    }
}
