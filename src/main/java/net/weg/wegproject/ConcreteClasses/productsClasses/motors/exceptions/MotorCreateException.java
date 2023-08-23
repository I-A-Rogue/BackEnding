package net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions;

public class MotorCreateException extends RuntimeException{
    public MotorCreateException() {
        super("Não foi possivel criar este motor");
    }
}
