package it.itc.restapi_itc.application.port.in;

import it.itc.restapi_itc.application.command.GetTestModelCommand;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;

import java.util.Optional;

public interface GetTestModelUseCase {

    Optional<TestModel> retrieveTestModel(GetTestModelCommand getTestModelCommand);

}
