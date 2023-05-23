package it.itc.company_project_rest.domain.model.exception;

public class EmptyField extends RuntimeException{

    public EmptyField(String msg){
        super(msg);
    }
}
