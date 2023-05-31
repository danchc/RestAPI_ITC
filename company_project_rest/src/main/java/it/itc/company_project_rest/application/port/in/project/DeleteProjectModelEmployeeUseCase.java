package it.itc.company_project_rest.application.port.in.project;

import it.itc.company_project_rest.application.command.project.DeleteProjectModelEmployeeCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteProjectModelEmployeeUseCase {

    void deleteEmployee(DeleteProjectModelEmployeeCommand deleteProjectModelEmployeeCommand);

}
