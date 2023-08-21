package net.weg.wegproject.concreteClasses.company.exceptions;

public class NoCompanyException extends RuntimeException{
    public NoCompanyException() {
        super("Empresa inexitente");
    }
}
