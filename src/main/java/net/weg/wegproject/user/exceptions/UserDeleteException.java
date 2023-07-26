package net.weg.wegproject.user.exceptions;

public class UserDeleteException extends RuntimeException{
    public UserDeleteException() {
        super("Não foi possivel deletar este usuário");
    }
}
