package net.weg.wegproject.company.exceptions;

public class NoCompaniesException extends RuntimeException{
    public NoCompaniesException() {
        super("Não exite nenhuma empresa encontrada");
    }
}
