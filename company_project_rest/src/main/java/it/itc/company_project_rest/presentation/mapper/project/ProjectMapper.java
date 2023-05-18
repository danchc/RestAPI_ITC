package it.itc.company_project_rest.presentation.mapper.project;

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.presentation.request.project.ProjectRequest;
import it.itc.company_project_rest.presentation.response.project.ProjectResponse;

/*

    Mapping class for Project

 */
public class ProjectMapper {

    /* fromRequestToCommand */
    public CreateProjectModelCommand fromRequestToCommand(ProjectRequest projectRequest){
        return new CreateProjectModelCommand(
                projectRequest.getName(),
                projectRequest.getStartDate(),
                projectRequest.getEndDate()
        );
    }

    /* fromModelToResponse */
    public ProjectResponse fromModelToResponse(ProjectModel projectModel){
        return new ProjectResponse(
                projectModel.getName(),
                projectModel.getStartDate(),
                projectModel.getEndDate()
        );
    }

}
