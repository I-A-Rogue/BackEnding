package net.weg.wegproject.concreteClasses.productsClasses.ink.exceptions;

public class NoInkException extends RuntimeException{
    public NoInkException() {
        super("Tinta inexitente");
    }
}
