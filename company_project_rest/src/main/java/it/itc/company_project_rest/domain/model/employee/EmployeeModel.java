package it.itc.company_project_rest.domain.model.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class EmployeeModel {

    /* fields */

    private final EmployeeId employeeId;
    private String name;
    private String surname;
    private String email;
    private DepartmentModel departmentModel;
    private List<ProjectModel> projectModelList;

    /* builder */

    @Builder
    private EmployeeModel(EmployeeId employeeId, String name, String surname, String email, DepartmentModel departmentModel, List<ProjectModel> projectModelList) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departmentModel = departmentModel;
        this.projectModelList = projectModelList;
    }

}
