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
        return ProjectEntity.builder()
                .projectId(projectModel.getProjectId().getProjectId())
                .name(projectModel.getName())
                .startDate(projectModel.getStartDate())
                .endDate(projectModel.getEndDate())
                .build();
    }

    /* fromEntityToModel */
    public ProjectModel fromEntityToModel(ProjectEntity projectEntity) {
        return ProjectModel.builder()
                .projectId(new ProjectId(projectEntity.getProjectId()))
                .name(projectEntity.getName())
                .startDate(projectEntity.getStartDate())
                .endDate(projectEntity.getEndDate())
                .build();
    }


}
