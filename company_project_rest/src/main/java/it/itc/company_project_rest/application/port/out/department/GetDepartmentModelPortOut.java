package it.itc.company_project_rest.application.port.out.department;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;

import java.util.Optional;

/*

    Porting Out RETRIEVE Interface for DepartmentModel

 */

public interface GetDepartmentModelPortOut {

    Optional<DepartmentModel> retrieveById(DepartmentId departmentId);

}
