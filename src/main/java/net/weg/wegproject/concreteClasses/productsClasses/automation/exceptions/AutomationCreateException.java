package net.weg.wegproject.concreteClasses.productsClasses.automation.exceptions;

public class AutomationCreateException extends RuntimeException{
    public AutomationCreateException() {
        super("Não foi possivel criar esta automação");
    }
}
