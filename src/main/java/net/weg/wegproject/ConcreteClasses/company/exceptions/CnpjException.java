package net.weg.wegproject.ConcreteClasses.company.exceptions;

public class CnpjException extends RuntimeException{
    public CnpjException() {
        super("Não foi possivel criar esta empresa, pois CNPJ inválido");
    }
}
