package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.UpdateProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateProjectModelUseCase {

    ProjectModel updateProjectModel(UpdateProjectModelCommand updateProjectModelCommand);

}
