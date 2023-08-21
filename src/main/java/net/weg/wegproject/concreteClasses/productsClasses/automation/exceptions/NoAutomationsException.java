package net.weg.wegproject.concreteClasses.productsClasses.automation.exceptions;

public class NoAutomationsException extends RuntimeException{
    public NoAutomationsException() {
        super("Não exite nenhuma automação cadastrada");
    }
}
