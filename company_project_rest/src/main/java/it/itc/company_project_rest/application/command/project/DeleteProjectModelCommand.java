package it.itc.company_project_rest.application.command.project;

import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProjectModelCommand {

    private ProjectId projectId;

}
