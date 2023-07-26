package net.weg.wegproject.security.exceptions;

public class NoSecurityException extends RuntimeException{
    public NoSecurityException() {
        super("Segurança inexitente");
    }
}
