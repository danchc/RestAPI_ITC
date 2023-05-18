package it.itc.company_project_rest.application.command.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProjectModelCommand {

    private String name;
    private String startDay;
    private String endDay;

}
