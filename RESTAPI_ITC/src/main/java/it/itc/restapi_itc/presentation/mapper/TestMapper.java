package it.itc.restapi_itc.presentation.mapper;


import it.itc.restapi_itc.application.command.CreateTestCommand;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.presentation.request.TestRequest;
import it.itc.restapi_itc.presentation.response.TestResponse;

/*
    Classe per il mapper:
        Request -> Command
        Model -> Response
 */
public class TestMapper {

    /* metodo per il mapping da Request a Command */
    public CreateTestCommand fromRequestToCommand(TestRequest testRequest){
        return new CreateTestCommand(
                testRequest.phrase
        );
    }

    /* metodo per il mapping da Model a Response */
    public TestResponse fromModelToResponse(TestModel testModel){
        return new TestResponse(
                testModel.getPhrase()
        );
    }
}
