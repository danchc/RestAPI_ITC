package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.DeleteEmployeeModelProjectCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteEmployeeModelProjectUseCase {

    void deleteProject(DeleteEmployeeModelProjectCommand deleteEmployeeModelProjectCommand);

}
