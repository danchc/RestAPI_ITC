package it.itc.restapi_itc.application.command;

import it.itc.restapi_itc.domain.model.TestId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class GetTestModelCommand {

    private TestId testId;
}
