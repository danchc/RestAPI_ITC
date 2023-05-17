package it.itc.restapi_itc.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*
    Classe per il command per la creazione di un TestModel.
 */
@Getter
@AllArgsConstructor
public class CreateTestCommand {

    private final String phrase;

}
