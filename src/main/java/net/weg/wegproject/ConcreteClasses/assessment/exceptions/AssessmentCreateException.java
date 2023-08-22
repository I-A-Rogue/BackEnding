package net.weg.wegproject.ConcreteClasses.assessment.exceptions;

public class AssessmentCreateException extends RuntimeException{
    public AssessmentCreateException() {
        super("Não foi possivel criar esta avaliação");
    }
}
