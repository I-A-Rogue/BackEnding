package net.weg.wegproject.ConcreteClasses.address.exceptions;

public class AddressCreateException extends RuntimeException{
    public AddressCreateException() {
        super("Não foi possivel criar este endereço");
    }
}
