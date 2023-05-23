package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import jakarta.annotation.Nullable;

import java.util.Optional;

public interface GetProjectModelPortOut {

    Optional<ProjectModel> retrieveById(ProjectId projectId);

}
