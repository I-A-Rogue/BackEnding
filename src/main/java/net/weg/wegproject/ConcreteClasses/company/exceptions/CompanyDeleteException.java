package net.weg.wegproject.ConcreteClasses.company.exceptions;

public class CompanyDeleteException extends RuntimeException{
    public CompanyDeleteException() {
        super("Não foi possivel deletar esta empresa");
    }
}
