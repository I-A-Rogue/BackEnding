package net.weg.wegproject.concreteClasses.productsClasses.security.exceptions;

public class NoSecurityException extends RuntimeException{
    public NoSecurityException() {
        super("Segurança inexitente");
    }
}
