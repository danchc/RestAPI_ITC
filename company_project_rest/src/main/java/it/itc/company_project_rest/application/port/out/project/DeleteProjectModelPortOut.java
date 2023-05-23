package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.project.ProjectId;

/*

    Porting Out DELETE Interface for ProjectModel

 */
public interface DeleteProjectModelPortOut {

    void deleteById(ProjectId projectId);

}
