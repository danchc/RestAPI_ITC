package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.GetEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GetEmployeeModelUseCase {

    Optional<EmployeeModel> retrieveEmployee(GetEmployeeModelCommand getEmployeeModelCommand);
}
