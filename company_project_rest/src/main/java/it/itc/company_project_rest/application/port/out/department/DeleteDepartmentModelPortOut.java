package it.itc.company_project_rest.application.port.out.department;

import it.itc.company_project_rest.domain.model.department.DepartmentId;

/*

    Porting Out DELETE Interface for DepartmentModel

 */

public interface DeleteDepartmentModelPortOut {

    void deleteById(DepartmentId departmentId);

}
