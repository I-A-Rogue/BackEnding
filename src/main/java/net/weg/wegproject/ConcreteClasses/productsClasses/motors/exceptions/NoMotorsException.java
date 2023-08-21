package net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions;

public class NoMotorsException extends RuntimeException{
    public NoMotorsException() {
        super("Não exite nenhum motor cadastrado");
    }
}
