package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.GetAllProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface GetAllProjectModelUseCase {

    Page<ProjectModel> getAllProjects(GetAllProjectModelCommand getAllProjectModelCommand);
}
