package net.weg.wegproject.ConcreteClasses.productsClasses.automation.exceptions;

public class AutomationUpdateException extends RuntimeException{
    public AutomationUpdateException() {
        super("Não foi possível editar esta automação");
    }
}
