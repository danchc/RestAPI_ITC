package it.itc.company_project_rest.application.port.out.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;

/*

    Porting Out UPDATE Interface for EmployeeModel

 */
public interface UpdateEmployeeModelPortOut {

    EmployeeModel persist(EmployeeModel employeeModel);
    void update(EmployeeId employeeId, ProjectId projectId);

}
