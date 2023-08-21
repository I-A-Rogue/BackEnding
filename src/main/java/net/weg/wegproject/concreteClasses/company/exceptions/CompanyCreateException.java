package net.weg.wegproject.concreteClasses.company.exceptions;

public class CompanyCreateException extends RuntimeException{
    public CompanyCreateException() {
        super("Não foi possivel criar esta empresa");
    }
}
