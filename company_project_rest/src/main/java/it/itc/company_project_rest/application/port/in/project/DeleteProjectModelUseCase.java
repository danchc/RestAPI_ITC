package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.DeleteProjectModelCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteProjectModelUseCase {

    void deleteProjectModel(DeleteProjectModelCommand deleteProjectModelCommand);

}
