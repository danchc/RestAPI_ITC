package it.itc.company_project_rest.application.command.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeModelCommand {

    private EmployeeId employeeId;
    private String name;
    private String surname;
    private String email;
    private DepartmentModel departmentModel;
    private ProjectModel projectModel;

}
