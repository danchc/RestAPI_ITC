package it.itc.company_project_rest.application.port.out.project;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;

public interface UpdateProjectModelEmployeePortOut {

    void update(ProjectId projectId, EmployeeId employeeId);
}
