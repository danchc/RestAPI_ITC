package it.itc.company_project_rest.infrastructure.jpa.mapper.project;


import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;

/*

    Mapping class for Department

 */
public class ProjectMapper {

    /* fromModelToEntity */
    public ProjectEntity fromModelToEntity(ProjectModel projectModel) {
        return new ProjectEntity(
                projectModel.getProjectId().getProjectId(),
                projectModel.getName(),
                projectModel.getStartDate(),
                projectModel.getEndDate()
        );
    }

    /* fromEntityToModel */
    public ProjectModel fromEntityToModel(ProjectEntity projectEntity) {
        return new ProjectModel(
                new ProjectId(projectEntity.getProjectId()),
                projectEntity.getName(),
                projectEntity.getStartDate(),
                projectEntity.getEndDate()
        );
    }


}
