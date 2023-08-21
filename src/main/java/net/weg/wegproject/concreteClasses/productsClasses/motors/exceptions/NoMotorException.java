package net.weg.wegproject.concreteClasses.productsClasses.motors.exceptions;

public class NoMotorException extends RuntimeException{
    public NoMotorException() {
        super("Motor inexitente");
    }
}
