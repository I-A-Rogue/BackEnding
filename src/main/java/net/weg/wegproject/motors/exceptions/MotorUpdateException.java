package net.weg.wegproject.motors.exceptions;

public class MotorUpdateException extends RuntimeException{
    public MotorUpdateException() {
        super("Não foi possível editar este motor");
    }
}
