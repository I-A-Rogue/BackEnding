package net.weg.wegproject.ConcreteClasses.user.exceptions;

public class NoUsersException extends RuntimeException{
    public NoUsersException() {
        super("Não exite nenhum usuário cadastrado");
    }
}
