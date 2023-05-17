package it.itc.restapi_itc.application.command;

import it.itc.restapi_itc.domain.model.TestId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTestModelCommand {

    private TestId testId;
    private String phrase;


}
