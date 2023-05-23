package it.itc.company_project_rest.application.port.out.department;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;

/*

    Porting Out CREATE Interface for DepartmentModel

 */

public interface CreateDepartmentModelPortOut {

    DepartmentModel persist(DepartmentModel departmentModel);

}
