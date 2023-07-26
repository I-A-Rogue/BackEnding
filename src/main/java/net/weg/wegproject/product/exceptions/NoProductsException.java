package net.weg.wegproject.product.exceptions;

public class NoProductsException extends RuntimeException{
    public NoProductsException() {
        super("Não exite nenhum produto cadastrada");
    }
}
