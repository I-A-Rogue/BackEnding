package net.weg.wegproject.automation.exceptions;

public class AutomationUpdateException extends RuntimeException{
    public AutomationUpdateException() {
        super("Não foi possível editar esta automação");
    }
}
