package net.weg.wegproject.company.exceptions;

public class CompanyCreateException extends RuntimeException{
    public CompanyCreateException() {
        super("Não foi possivel criar esta empresa");
    }
}
