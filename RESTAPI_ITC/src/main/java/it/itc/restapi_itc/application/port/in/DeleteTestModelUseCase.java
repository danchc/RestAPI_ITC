package it.itc.restapi_itc.application.port.in;

import it.itc.restapi_itc.application.command.DeleteTestModelCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteTestModelUseCase {

    void deleteTestModel(DeleteTestModelCommand deleteTestModelCommand);
}
