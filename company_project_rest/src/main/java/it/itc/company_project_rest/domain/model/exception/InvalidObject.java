package it.itc.company_project_rest.domain.model.exception;

public class InvalidObject extends RuntimeException{

    public InvalidObject(String msg) {
        super(msg);
    }
}
