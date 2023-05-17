package it.itc.restapi_itc.application.service;

import it.itc.restapi_itc.application.command.CreateTestModelCommand;
import it.itc.restapi_itc.application.port.in.CreateTestModelUseCase;
import it.itc.restapi_itc.application.port.out.CreateTestModelPortOut;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.application.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateTestModelService implements CreateTestModelUseCase {


    private final CreateTestModelPortOut createTestModelPortOut;
    private TestMapper testMapper = new TestMapper();

    @Override
    public TestModel createTestModel(CreateTestModelCommand createTestModelCommand) {
        log.info("#### CREATING TESTMODEL ####");
        TestModel testModel = this.testMapper.fromCommandToModel(createTestModelCommand);
        log.debug("#### TESTMODEL CREATED {} ####", testModel);
        return createTestModelPortOut.persist(testModel);
    }
}
