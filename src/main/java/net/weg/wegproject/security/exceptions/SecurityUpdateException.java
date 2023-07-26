package net.weg.wegproject.security.exceptions;

public class SecurityUpdateException extends RuntimeException{
    public SecurityUpdateException() {
        super("Não foi possível editar esta segurança");
    }
}
