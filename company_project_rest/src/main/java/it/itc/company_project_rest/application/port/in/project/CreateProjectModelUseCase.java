package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import org.springframework.stereotype.Repository;

/*

    Interface for ProjectModel CREATE Use Case

 */

@Repository
public interface CreateProjectModelUseCase {

    ProjectModel createProjectModel(CreateProjectModelCommand createProjectModelCommand);
}
