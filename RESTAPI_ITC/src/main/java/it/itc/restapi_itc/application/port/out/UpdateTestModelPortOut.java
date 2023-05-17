package it.itc.restapi_itc.application.port.out;

import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;

import java.util.UUID;

public interface UpdateTestModelPortOut {

    TestModel updateById(TestModel testModel);
}
