package it.itc.company_project_rest.application.command.project;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*

    Command for Create ProjectModel

 */

@Getter
@AllArgsConstructor
public class CreateProjectModelCommand {

    private String name;
    private String startDay;
    private String endDay;

}
