package it.itc.restapi_itc.application.port.in;

import it.itc.restapi_itc.application.command.UpdateTestModelCommand;
import it.itc.restapi_itc.domain.model.TestModel;

public interface UpdateTestModelUseCase {

    TestModel updateTestModel(UpdateTestModelCommand updateTestModelCommand);

}
