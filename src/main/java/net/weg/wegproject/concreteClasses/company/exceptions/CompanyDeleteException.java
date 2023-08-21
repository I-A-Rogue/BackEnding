package net.weg.wegproject.concreteClasses.company.exceptions;

public class CompanyDeleteException extends RuntimeException{
    public CompanyDeleteException() {
        super("Não foi possivel deletar esta empresa");
    }
}
