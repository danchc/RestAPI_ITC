package it.itc.company_project_rest.presentation.response.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class GetEmployeeResponse {

    private final String name;
    private final String surname;
    private final String email;
    private final DepartmentModel departmentModel;
    private Set<ProjectModel> projectModelSet;



}
