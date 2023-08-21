package net.weg.wegproject.concreteClasses.productsClasses.automation.exceptions;

public class NoAutomationException extends RuntimeException{
    public NoAutomationException() {
        super("automação inexitente");
    }
}
