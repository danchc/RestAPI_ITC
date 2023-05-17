package it.itc.restapi_itc.application.port.out;

import it.itc.restapi_itc.domain.model.TestModel;

public interface CreateTestModelPortOut {

    TestModel persist(TestModel testModel);

}
