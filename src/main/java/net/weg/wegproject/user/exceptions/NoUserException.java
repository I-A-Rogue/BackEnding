package net.weg.wegproject.user.exceptions;

public class NoUserException extends RuntimeException{
    public NoUserException() {
        super("Usuário inexitente");
    }
}
