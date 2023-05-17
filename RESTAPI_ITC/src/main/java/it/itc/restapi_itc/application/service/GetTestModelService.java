package it.itc.restapi_itc.application.service;

import it.itc.restapi_itc.application.command.GetTestModelCommand;
import it.itc.restapi_itc.application.port.in.GetTestModelUseCase;
import it.itc.restapi_itc.application.port.out.GetTestModelPortOut;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTestModelService implements GetTestModelUseCase {

    private final GetTestModelPortOut getTestModelPortOut;


    @Override
    public Optional<TestModel> retrieveTestModel(GetTestModelCommand getTestModelCommand) {
        log.info("#### RETRIEVING TESTMODEL ####");
        return getTestModelPortOut.findById(
                getTestModelCommand.getTestId()
        );
    }
}
