package net.weg.wegproject.security.exceptions;

public class NoSecuritysException extends RuntimeException{
    public NoSecuritysException() {
        super("Não exite nenhuma segurança cadastrada");
    }
}
