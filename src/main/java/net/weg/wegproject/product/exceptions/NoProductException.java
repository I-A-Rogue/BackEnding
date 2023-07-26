package net.weg.wegproject.product.exceptions;

public class NoProductException extends RuntimeException{
    public NoProductException() {
        super("Produto inexitente");
    }
}
