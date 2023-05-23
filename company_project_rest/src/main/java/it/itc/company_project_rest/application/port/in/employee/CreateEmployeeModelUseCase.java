package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.CreateEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import org.springframework.stereotype.Repository;

/*

    Interface for EmployeeModel CREATE Use Case

 */
@Repository
public interface CreateEmployeeModelUseCase {

    EmployeeModel createEmployeeModel(CreateEmployeeModelCommand createEmployeeModelCommand);

}
