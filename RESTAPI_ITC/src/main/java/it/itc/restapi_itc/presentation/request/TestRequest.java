package it.itc.restapi_itc.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
    Classe per la Request dell'oggetto TestModel.
    Contiene ciò che la richiesta deve avere secondo delle specifiche.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestRequest {

    public String phrase;

}
