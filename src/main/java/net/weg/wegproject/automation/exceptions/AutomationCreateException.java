package net.weg.wegproject.automation.exceptions;

public class AutomationCreateException extends RuntimeException{
    public AutomationCreateException() {
        super("Não foi possivel criar esta automação");
    }
}
