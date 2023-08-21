package net.weg.wegproject.concreteClasses.user.exceptions;

public class UserUpdateException extends RuntimeException{
    public UserUpdateException() {
        super("Não foi possível editar este usuário");
    }
}
