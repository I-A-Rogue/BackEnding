package net.weg.wegproject.user.exceptions;

public class NoUsersException extends RuntimeException{
    public NoUsersException() {
        super("Não exite nenhum usuário cadastrado");
    }
}
