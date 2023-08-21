package net.weg.wegproject.ConcreteClasses.productsClasses.security.exceptions;

public class SecurityCreateException extends RuntimeException{
    public SecurityCreateException() {
        super("Não foi possivel criar esta segurança");
    }
}
