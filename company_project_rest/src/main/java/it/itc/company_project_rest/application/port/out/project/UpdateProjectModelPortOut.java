package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.project.ProjectModel;

public interface UpdateProjectModelPortOut {

    ProjectModel persist(ProjectModel projectModel);
}
