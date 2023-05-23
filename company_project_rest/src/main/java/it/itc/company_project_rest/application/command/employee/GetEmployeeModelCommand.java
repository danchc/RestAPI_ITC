package it.itc.company_project_rest.application.command.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;


/*

    Command for Retrieve EmployeeModel by ID

 */
@Getter
@AllArgsConstructor
public class GetEmployeeModelCommand {

    private EmployeeId employeeId;

}
