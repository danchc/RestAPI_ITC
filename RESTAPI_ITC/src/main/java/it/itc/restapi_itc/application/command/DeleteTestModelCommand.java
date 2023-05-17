package it.itc.restapi_itc.application.command;

import it.itc.restapi_itc.domain.model.TestId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteTestModelCommand {

    private TestId testId;
}
