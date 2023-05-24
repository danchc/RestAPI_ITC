package it.itc.company_project_rest.domain.model.exception;

public class AlreadyExists extends RuntimeException{

    public AlreadyExists(String msg) {
        super(msg);
    }
}
