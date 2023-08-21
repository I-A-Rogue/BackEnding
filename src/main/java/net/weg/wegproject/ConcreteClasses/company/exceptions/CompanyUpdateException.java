package net.weg.wegproject.company.exceptions;

public class CompanyUpdateException extends RuntimeException{
    public CompanyUpdateException() {
        super("Não foi possível editar esta empresa");
    }
}
