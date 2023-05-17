package it.itc.restapi_itc.application.service;

import it.itc.restapi_itc.application.command.DeleteTestModelCommand;
import it.itc.restapi_itc.application.mapper.TestMapper;
import it.itc.restapi_itc.application.port.in.DeleteTestModelUseCase;
import it.itc.restapi_itc.application.port.out.DeleteTestModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteTestModelService implements DeleteTestModelUseCase {

    private TestMapper testMapper = new TestMapper();
    private final DeleteTestModelPortOut deleteTestModelPortOut;

    @Override
    public void deleteTestModel(DeleteTestModelCommand deleteTestModelCommand) {
        log.info("DELETING TESTMODEL");
        deleteTestModelPortOut.deleteById(deleteTestModelCommand.getTestId());

    }
}
