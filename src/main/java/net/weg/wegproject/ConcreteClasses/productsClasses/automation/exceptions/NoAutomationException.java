package net.weg.wegproject.ConcreteClasses.productsClasses.automation.exceptions;

public class NoAutomationException extends RuntimeException{
    public NoAutomationException() {
        super("automação inexitente");
    }
}
