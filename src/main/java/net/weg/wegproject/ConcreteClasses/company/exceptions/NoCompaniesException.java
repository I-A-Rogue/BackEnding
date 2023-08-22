package net.weg.wegproject.ConcreteClasses.company.exceptions;

public class NoCompaniesException extends RuntimeException{
    public NoCompaniesException() {
        super("Não exite nenhuma empresa encontrada");
    }
}
