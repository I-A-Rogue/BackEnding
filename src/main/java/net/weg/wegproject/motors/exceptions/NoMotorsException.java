package net.weg.wegproject.motors.exceptions;

public class NoMotorsException extends RuntimeException{
    public NoMotorsException() {
        super("Não exite nenhum motor cadastrado");
    }
}
