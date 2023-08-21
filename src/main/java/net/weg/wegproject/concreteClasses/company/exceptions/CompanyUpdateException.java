package net.weg.wegproject.concreteClasses.company.exceptions;

public class CompanyUpdateException extends RuntimeException{
    public CompanyUpdateException() {
        super("Não foi possível editar esta empresa");
    }
}
