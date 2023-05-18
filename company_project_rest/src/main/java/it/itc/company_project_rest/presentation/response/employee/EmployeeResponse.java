package it.itc.company_project_rest.presentation.response.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeResponse {

    private String name;
    private String surname;
    private String email;
    private DepartmentModel departmentModel;

}

