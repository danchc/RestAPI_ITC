package it.itc.restapi_itc.application.port.out;

import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;

import java.util.Optional;

public interface GetTestModelPortOut {

    Optional<TestModel> findById(TestId testId);
}
