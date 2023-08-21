package net.weg.wegproject.concreteClasses.assessment.exceptions;

public class NoAssessmentException extends RuntimeException{
    public NoAssessmentException() {
        super("avaliação inexitente");
    }
}
