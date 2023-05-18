package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;

/*

    Porting Out Interface for ProjectModel

 */
public interface CreateProjectModelPortOut {

    ProjectModel persist(ProjectModel projectModel);
}
