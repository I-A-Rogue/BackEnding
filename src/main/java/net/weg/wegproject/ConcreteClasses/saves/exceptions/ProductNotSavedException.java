package net.weg.wegproject.ConcreteClasses.saves.exceptions;

public class ProductNotSavedException extends RuntimeException{
    public ProductNotSavedException() {
        super("Produto não salvo!");
    }
}
