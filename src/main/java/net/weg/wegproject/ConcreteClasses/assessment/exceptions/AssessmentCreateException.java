package net.weg.wegproject.assessment.exceptions;

public class AssessmentCreateException extends RuntimeException{
    public AssessmentCreateException() {
        super("Não foi possivel criar esta avaliação");
    }
}
