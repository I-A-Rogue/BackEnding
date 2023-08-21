package net.weg.wegproject.concreteClasses.user.exceptions;

public class UserDeleteException extends RuntimeException{
    public UserDeleteException() {
        super("Não foi possivel deletar este usuário");
    }
}
