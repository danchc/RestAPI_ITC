package it.itc.company_project_rest.application.port.out.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;

public interface DeleteEmployeeModelProjectPortOut {

    void deleteProject(EmployeeId employeeId, ProjectId projectId);
}
