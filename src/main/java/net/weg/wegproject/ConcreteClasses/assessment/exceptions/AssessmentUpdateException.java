package net.weg.wegproject.assessment.exceptions;

public class AssessmentUpdateException extends RuntimeException{
    public AssessmentUpdateException() {
        super("Não foi possível editar esta avaliação");
    }
}
