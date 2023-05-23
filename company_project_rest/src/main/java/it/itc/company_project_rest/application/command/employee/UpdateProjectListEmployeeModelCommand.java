package it.itc.company_project_rest.application.command.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateProjectListEmployeeModelCommand {

    private EmployeeId employeeId;
    private ProjectId projectId;
}
