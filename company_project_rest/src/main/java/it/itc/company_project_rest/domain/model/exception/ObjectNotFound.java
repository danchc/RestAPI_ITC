package it.itc.company_project_rest.domain.model.exception;

public class ObjectNotFound extends RuntimeException{

    public ObjectNotFound(String errorMessage) {
        super(errorMessage);
    }
}
