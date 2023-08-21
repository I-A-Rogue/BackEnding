package net.weg.wegproject.company.exceptions;

public class NoCompanyException extends RuntimeException{
    public NoCompanyException() {
        super("Empresa inexitente");
    }
}
