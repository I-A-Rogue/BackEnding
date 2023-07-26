package net.weg.wegproject.assessment.exceptions;

public class NoAssessmentException extends RuntimeException{
    public NoAssessmentException() {
        super("avaliação inexitente");
    }
}
