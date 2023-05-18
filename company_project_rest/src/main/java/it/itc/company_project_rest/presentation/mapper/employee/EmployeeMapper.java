package it.itc.company_project_rest.presentation.mapper.employee;

import it.itc.company_project_rest.application.command.employee.CreateEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.presentation.request.employee.EmployeeRequest;
import it.itc.company_project_rest.presentation.response.employee.EmployeeResponse;

public class EmployeeMapper {

    /* fromRequestToCommand */
    public CreateEmployeeModelCommand fromRequestToCommand(EmployeeRequest employeeRequest){
        return new CreateEmployeeModelCommand(
                employeeRequest.getName(),
                employeeRequest.getSurname(),
                employeeRequest.getEmail()
        );
    }


    /* fromModelToResponse */
    public EmployeeResponse fromModelToResponse(EmployeeModel employeeModel){
        return new EmployeeResponse(
                employeeModel.getName(),
                employeeModel.getSurname(),
                employeeModel.getEmail(),
                employeeModel.getDepartmentModel()
        );
    }
}
