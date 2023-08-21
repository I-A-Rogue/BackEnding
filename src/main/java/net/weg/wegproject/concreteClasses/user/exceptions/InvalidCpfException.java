package net.weg.wegproject.concreteClasses.user.exceptions;

public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException() {
        super("CPF/CNPJ inválido ou inexistente");
    }
}
