package net.weg.wegproject.motors.exceptions;

public class MotorCreateException extends RuntimeException{
    public MotorCreateException() {
        super("Não foi possivel criar este motor");
    }
}
