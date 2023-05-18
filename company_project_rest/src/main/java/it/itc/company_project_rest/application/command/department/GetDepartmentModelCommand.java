package it.itc.company_project_rest.application.command.department;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetDepartmentModelCommand {

    private DepartmentId departmentId;

}
