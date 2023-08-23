package net.weg.wegproject.ConcreteClasses.user.exceptions;

public class UserDeleteException extends RuntimeException{
    public UserDeleteException() {
        super("Não foi possivel deletar este usuário");
    }
}
