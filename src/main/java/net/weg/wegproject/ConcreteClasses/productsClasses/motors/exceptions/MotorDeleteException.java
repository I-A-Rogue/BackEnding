package net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions;

public class MotorDeleteException extends RuntimeException{
    public MotorDeleteException() {
        super("Não foi possivel deletar este motor");
    }
}
