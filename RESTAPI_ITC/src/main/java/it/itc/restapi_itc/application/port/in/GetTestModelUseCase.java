package it.itc.restapi_itc.application.port.in;

import it.itc.restapi_itc.application.command.GetTestModelCommand;
import it.itc.restapi_itc.domain.model.TestModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GetTestModelUseCase {

    Optional<TestModel> retrieveTestModel(GetTestModelCommand getTestModelCommand);

}
