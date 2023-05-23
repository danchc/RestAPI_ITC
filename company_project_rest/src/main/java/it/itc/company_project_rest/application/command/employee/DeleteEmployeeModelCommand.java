package it.itc.company_project_rest.application.command.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteEmployeeModelCommand {

    private EmployeeId employeeId;

}
