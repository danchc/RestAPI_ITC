package it.itc.restapi_itc.application.port.in;

import it.itc.restapi_itc.application.command.CreateTestCommand;
import it.itc.restapi_itc.domain.model.TestModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateTestModelUseCase {

    TestModel createTestModel(CreateTestCommand createTestCommand);
}
