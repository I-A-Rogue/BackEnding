package net.weg.wegproject.ConcreteClasses.user.exceptions;

public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException() {
        super("CPF/CNPJ inválido ou inexistente");
    }
}
