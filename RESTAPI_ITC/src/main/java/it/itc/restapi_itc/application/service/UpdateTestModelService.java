package it.itc.restapi_itc.application.service;

import it.itc.restapi_itc.application.command.UpdateTestModelCommand;
import it.itc.restapi_itc.application.port.in.UpdateTestModelUseCase;
import it.itc.restapi_itc.application.port.out.GetTestModelPortOut;
import it.itc.restapi_itc.application.port.out.UpdateTestModelPortOut;
import it.itc.restapi_itc.domain.model.TestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateTestModelService implements UpdateTestModelUseCase {

    private final UpdateTestModelPortOut updateTestModelPortOut;
    private final GetTestModelPortOut getTestModelPortOut;

    @Override
    public TestModel updateTestModel(UpdateTestModelCommand updateTestModelCommand) {
        log.info("### UPDATING TESTMODEL ###");

        return getTestModelPortOut.findById(updateTestModelCommand.getTestId()).map(
                testModel -> {
                    testModel.setPhrase(updateTestModelCommand.getPhrase());
                    return updateTestModelPortOut.updateById(testModel);
                }
        ).get();
    }
}
