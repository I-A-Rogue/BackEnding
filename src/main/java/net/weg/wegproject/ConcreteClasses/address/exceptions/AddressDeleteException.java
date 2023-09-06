package net.weg.wegproject.ConcreteClasses.address.exceptions;

public class AddressDeleteException extends RuntimeException{
    public AddressDeleteException() {
        super("Não foi possivel deletar este endereço");
    }
}
