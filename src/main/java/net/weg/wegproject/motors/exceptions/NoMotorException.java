package net.weg.wegproject.motors.exceptions;

public class NoMotorException extends RuntimeException{
    public NoMotorException() {
        super("Motor inexitente");
    }
}
