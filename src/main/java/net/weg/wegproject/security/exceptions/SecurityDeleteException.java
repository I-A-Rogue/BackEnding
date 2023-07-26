package net.weg.wegproject.security.exceptions;

public class SecurityDeleteException extends RuntimeException{
    public SecurityDeleteException() {
        super("Não foi possivel deletar esta segurança");
    }
}
