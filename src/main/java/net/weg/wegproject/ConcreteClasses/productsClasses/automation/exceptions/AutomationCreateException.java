package net.weg.wegproject.ConcreteClasses.productsClasses.automation.exceptions;

public class AutomationCreateException extends RuntimeException{
    public AutomationCreateException() {
        super("Não foi possivel criar esta automação");
    }
}
