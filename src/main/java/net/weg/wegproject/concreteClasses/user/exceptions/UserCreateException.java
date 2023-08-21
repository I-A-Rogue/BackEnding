package net.weg.wegproject.concreteClasses.user.exceptions;

public class UserCreateException extends RuntimeException{
    public UserCreateException() {
        super("Não foi possivel criar este usuário");
    }
}
