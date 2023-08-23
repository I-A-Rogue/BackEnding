package net.weg.wegproject.ConcreteClasses.company.exceptions;

public class NoCompanyException extends RuntimeException{
    public NoCompanyException() {
        super("Empresa inexitente");
    }
}
