package net.weg.wegproject.ConcreteClasses.address.exceptions;

public class NoAddressesException extends RuntimeException{
    public NoAddressesException() {
        super("Não exite nenhum endereço cadastrada");
    }
}
