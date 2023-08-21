package net.weg.wegproject.concreteClasses.productsClasses.motors.exceptions;

public class NoMotorsException extends RuntimeException{
    public NoMotorsException() {
        super("Não exite nenhum motor cadastrado");
    }
}
