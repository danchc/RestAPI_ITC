package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.GetProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;

import java.util.Optional;

/*

    Interface for ProjectModel RETRIEVE Use Case

 */

public interface GetProjectModelUseCase {

    Optional<ProjectModel> retrieveProjectModel(GetProjectModelCommand getProjectModelCommand);

}
