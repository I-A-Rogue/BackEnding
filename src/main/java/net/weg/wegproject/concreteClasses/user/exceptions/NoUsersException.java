package net.weg.wegproject.concreteClasses.user.exceptions;

public class NoUsersException extends RuntimeException{
    public NoUsersException() {
        super("Não exite nenhum usuário cadastrado");
    }
}
