package net.weg.wegproject.concreteClasses.productsClasses.motors.exceptions;

public class MotorDeleteException extends RuntimeException{
    public MotorDeleteException() {
        super("Não foi possivel deletar este motor");
    }
}
