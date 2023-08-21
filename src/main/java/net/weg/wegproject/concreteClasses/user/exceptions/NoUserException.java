package net.weg.wegproject.concreteClasses.user.exceptions;

public class NoUserException extends RuntimeException{
    public NoUserException() {
        super("Usuário inexitente");
    }
}
