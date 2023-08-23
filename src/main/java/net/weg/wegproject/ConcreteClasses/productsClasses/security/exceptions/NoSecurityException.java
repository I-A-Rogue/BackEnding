package net.weg.wegproject.ConcreteClasses.productsClasses.security.exceptions;

public class NoSecurityException extends RuntimeException{
    public NoSecurityException() {
        super("Segurança inexitente");
    }
}
