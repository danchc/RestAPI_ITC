package it.itc.restapi_itc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/*
    Classe specifica per l'id di TestModel.
    Contiene:
        testId di tipo UUID.
 */

@Getter
@AllArgsConstructor
public class TestId {

    private final UUID testId;
}
