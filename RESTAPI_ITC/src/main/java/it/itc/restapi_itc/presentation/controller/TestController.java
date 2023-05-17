package it.itc.restapi_itc.presentation.controller;

import it.itc.restapi_itc.application.command.GetTestModelCommand;
import it.itc.restapi_itc.application.port.in.CreateTestModelUseCase;
import it.itc.restapi_itc.application.port.in.GetTestModelUseCase;
import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.presentation.mapper.TestMapper;
import it.itc.restapi_itc.presentation.request.TestRequest;
import it.itc.restapi_itc.presentation.response.TestResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/*
    Classe per il Controller che gestisce la parte Presentation.
    Presentation : gestisce il "dialogo" tra UI e utente.

 */

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final CreateTestModelUseCase createTestModelUseCase;
    private final GetTestModelUseCase getTestModelUseCase;
    private TestMapper testMapper = new TestMapper();

    /* metodo per creare un nuovo TestModel */
    @PostMapping
    public ResponseEntity<TestResponse> createTestModel(@RequestBody TestRequest testRequest) {
        log.info("###### CREATING NEW TESTMODEL #######");
        log.debug("##### REQUESTED TO CREATE {} #####", testRequest);
        TestResponse testResponse =
                testMapper.fromModelToResponse(createTestModelUseCase.createTestModel(testMapper.fromRequestToCommand(testRequest)));
        return new ResponseEntity<TestResponse>(testResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResponse> getTestModel(@PathVariable("id") UUID testModelId) {
        log.info("#### RETRIEVING TESTMODEL ####");
        log.debug("#### REQUESTED TO RETRIEVE TESTMODEL {}", testModelId);
        /* mi serve il command */
        GetTestModelCommand getTestModelCommand = new GetTestModelCommand(new TestId(testModelId));

        /* per ogni testmodel trovato allora lo mappo */
        Optional<TestResponse> testResponse = getTestModelUseCase.retrieveTestModel(getTestModelCommand).map(testMapper::fromModelToResponse);

        /* se è presente HttpStatus.OK con la responseEntity trovata
            altrimenti, NOT_FOUND */
        if(testResponse.isPresent()) {
            return ResponseEntity.ok(testResponse.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
