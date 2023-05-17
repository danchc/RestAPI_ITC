package it.itc.restapi_itc.application.mapper;


/*
    Classe per mappare da Command a TestModel.
    Questo mapping è intermedio tra Presentation e Infrastructure
 */

import it.itc.restapi_itc.application.command.CreateTestModelCommand;
import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;

import java.util.UUID;

public class TestMapper {

    /* metodo per la mappatura da Command a TestModel */
    public TestModel fromCommandToModel(CreateTestModelCommand createTestModelCommand){
        return new TestModel(
                new TestId(UUID.randomUUID()),
                createTestModelCommand.getPhrase()
        );
    }

}
