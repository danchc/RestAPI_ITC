package it.itc.restapi_itc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
    Modello per oggetto Test.
    Contiene:
        TestId come id di tipo TestId
        Frase come campo aggiuntivo
 */
@Getter
@Setter
@AllArgsConstructor
public class TestModel {

    private final TestId testId;
    private String phrase;

}
