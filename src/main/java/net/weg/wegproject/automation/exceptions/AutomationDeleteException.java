package net.weg.wegproject.automation.exceptions;

public class AutomationDeleteException extends RuntimeException{
    public AutomationDeleteException() {
        super("Não foi possivel deletar esta automação");
    }
}
