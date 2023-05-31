package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;

public interface DeleteProjectModelEmployeePortOut {

    void deleteEmployee(ProjectId projectId, EmployeeId employeeId);
}
