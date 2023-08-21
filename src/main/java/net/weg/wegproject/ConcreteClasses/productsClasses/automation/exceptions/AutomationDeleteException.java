package net.weg.wegproject.ConcreteClasses.productsClasses.automation.exceptions;

public class AutomationDeleteException extends RuntimeException{
    public AutomationDeleteException() {
        super("Não foi possivel deletar esta automação");
    }
}
