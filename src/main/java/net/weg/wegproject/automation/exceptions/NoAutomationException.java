package net.weg.wegproject.automation.exceptions;

public class NoAutomationException extends RuntimeException{
    public NoAutomationException() {
        super("automação inexitente");
    }
}
