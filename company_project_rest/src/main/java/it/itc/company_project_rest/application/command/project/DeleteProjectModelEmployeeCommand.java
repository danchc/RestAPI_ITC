package it.itc.company_project_rest.application.command.project;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProjectModelEmployeeCommand {

    private ProjectId projectId;
    private EmployeeId employeeId;

}
