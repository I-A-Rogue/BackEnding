package net.weg.wegproject.ConcreteClasses.assessment.exceptions;

public class NoAssessmentException extends RuntimeException{
    public NoAssessmentException() {
        super("avaliação inexitente");
    }
}
