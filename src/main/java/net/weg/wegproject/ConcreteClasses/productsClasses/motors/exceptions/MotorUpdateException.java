package net.weg.wegproject.ConcreteClasses.productsClasses.motors.exceptions;

public class MotorUpdateException extends RuntimeException{
    public MotorUpdateException() {
        super("Não foi possível editar este motor");
    }
}
