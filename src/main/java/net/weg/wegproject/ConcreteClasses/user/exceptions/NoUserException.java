package net.weg.wegproject.ConcreteClasses.user.exceptions;

public class NoUserException extends RuntimeException{
    public NoUserException() {
        super("Usuário inexitente");
    }
}
