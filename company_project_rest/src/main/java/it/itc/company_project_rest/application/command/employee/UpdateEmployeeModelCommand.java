package it.itc.company_project_rest.application.command.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateEmployeeModelCommand {

    private EmployeeId employeeId;
    private String name;
    private String surname;
    private String email;
    private DepartmentId departmentId;

}
