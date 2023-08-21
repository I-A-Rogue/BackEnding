package net.weg.wegproject.concreteClasses.productsClasses.automation.exceptions;

public class AutomationDeleteException extends RuntimeException{
    public AutomationDeleteException() {
        super("Não foi possivel deletar esta automação");
    }
}
