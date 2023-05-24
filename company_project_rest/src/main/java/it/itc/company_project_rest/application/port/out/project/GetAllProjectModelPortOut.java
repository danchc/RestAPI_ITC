package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.project.ProjectModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllProjectModelPortOut {

    Page<ProjectModel> findAll(Pageable pageable);

}
