package net.weg.wegproject.ConcreteClasses.address.exceptions;

public class AddressUpdateException extends RuntimeException{
    public AddressUpdateException() {
        super("Não foi possível editar este endereço");
    }
}
