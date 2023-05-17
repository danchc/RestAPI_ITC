package it.itc.restapi_itc.application.port.out;

import it.itc.restapi_itc.domain.model.TestId;

public interface DeleteTestModelPortOut {

    void deleteById(TestId testId);
}
