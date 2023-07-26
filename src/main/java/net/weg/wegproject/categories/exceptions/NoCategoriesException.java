package net.weg.wegproject.categories.exceptions;

public class NoCategoriesException extends RuntimeException{
    public NoCategoriesException() {
        super("categoria inexitente");
    }
}
