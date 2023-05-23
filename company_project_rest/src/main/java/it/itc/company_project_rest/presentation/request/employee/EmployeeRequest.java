package it.itc.company_project_rest.presentation.request.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String name;
    private String surname;
    private String email;
    private DepartmentModel departmentModel;
    private ProjectModel projectModel;

}
