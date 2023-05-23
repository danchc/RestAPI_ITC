package it.itc.company_project_rest.application.port.out.department;

import it.itc.company_project_rest.domain.model.department.DepartmentId;

public interface DeleteDepartmentModelPortOut {

    void deleteById(DepartmentId departmentId);

}
