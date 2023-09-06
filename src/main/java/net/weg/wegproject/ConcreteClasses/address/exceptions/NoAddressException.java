package net.weg.wegproject.ConcreteClasses.address.exceptions;

public class NoAddressException extends RuntimeException{
    public NoAddressException() {
        super("Endereço inexitente");
    }
}
