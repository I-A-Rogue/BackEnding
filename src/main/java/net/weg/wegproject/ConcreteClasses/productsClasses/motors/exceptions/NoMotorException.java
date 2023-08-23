package net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions;

public class NoMotorException extends RuntimeException{
    public NoMotorException() {
        super("Motor inexitente");
    }
}
