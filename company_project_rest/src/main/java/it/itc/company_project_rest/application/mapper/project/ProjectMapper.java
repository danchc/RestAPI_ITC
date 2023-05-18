package it.itc.company_project_rest.application.mapper.project;

/*

    Mapping class for Project

 */

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;

import java.util.UUID;

public class ProjectMapper {

    /* fromCommandToModel */
    public ProjectModel fromCommandToModel(CreateProjectModelCommand createProjectModelCommand) {
        return new ProjectModel(
                new ProjectId(UUID.randomUUID()),
                createProjectModelCommand.getName(),
                createProjectModelCommand.getStartDay(),
                createProjectModelCommand.getEndDay()
        );
    }

}
