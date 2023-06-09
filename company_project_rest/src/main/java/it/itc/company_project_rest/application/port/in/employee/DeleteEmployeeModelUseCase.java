package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.DeleteEmployeeModelCommand;
import org.springframework.stereotype.Repository;

/*

    Interface for EmployeeModel DELETE Use Case

 */
@Repository
public interface DeleteEmployeeModelUseCase {

    void deleteEmployeeModel(DeleteEmployeeModelCommand deleteEmployeeModelCommand);

}
