package net.weg.wegproject.ConcreteClasses.user.exceptions;

public class UserCreateException extends RuntimeException{
    public UserCreateException() {
        super("Não foi possivel criar este usuário");
    }
}
