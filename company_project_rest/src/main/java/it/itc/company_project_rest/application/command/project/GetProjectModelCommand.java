package it.itc.company_project_rest.application.command.project;

import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;


/*

    Command for Retrieve ProjectModel by ID

 */

@Getter
@AllArgsConstructor
public class GetProjectModelCommand {

    private ProjectId projectId;

}
