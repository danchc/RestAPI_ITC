package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.GetAllEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface GetAllEmployeeModelUseCase {

    Page<EmployeeModel> getAllEmployeeModel(GetAllEmployeeModelCommand getAllEmployeeModelCommand);
}
