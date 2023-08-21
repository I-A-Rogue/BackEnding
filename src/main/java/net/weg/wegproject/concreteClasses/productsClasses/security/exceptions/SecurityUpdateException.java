package net.weg.wegproject.concreteClasses.productsClasses.security.exceptions;

public class SecurityUpdateException extends RuntimeException{
    public SecurityUpdateException() {
        super("Não foi possível editar esta segurança");
    }
}
