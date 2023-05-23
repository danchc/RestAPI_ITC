package it.itc.company_project_rest.application.port.in.employee;

import it.itc.company_project_rest.application.command.employee.UpdateDepartmentEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateProjectListEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import org.springframework.stereotype.Repository;

/*

    Interface for EmployeeModel UPDATE Use Case

 */

@Repository
public interface UpdateEmployeeModelUseCase {

    EmployeeModel updateEmployeeModel(UpdateEmployeeModelCommand updateEmployeeModelCommand);

    EmployeeModel updateDepartmentEmployeeModel(UpdateDepartmentEmployeeModelCommand updateDepartmentEmployeeModelCommand);

    EmployeeModel updateProjectListEmployeeModel(UpdateProjectListEmployeeModelCommand updateProjectListEmployeeModelCommand);

}
