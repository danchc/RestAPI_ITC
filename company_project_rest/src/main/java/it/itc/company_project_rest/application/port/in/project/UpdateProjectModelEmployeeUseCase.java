package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.UpdateProjectModelEmployeeCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateProjectModelEmployeeUseCase {

    void addEmployeeProject(UpdateProjectModelEmployeeCommand updateProjectModelEmployeeCommand);

}
