package net.weg.wegproject.user.exceptions;

public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException() {
        super("CPF/CNPJ inválido ou inexistente");
    }
}
