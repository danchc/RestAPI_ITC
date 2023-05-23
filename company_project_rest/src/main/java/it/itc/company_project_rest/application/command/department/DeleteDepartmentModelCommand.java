package it.itc.company_project_rest.application.command.department;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*

    Command for Delete DepartmentModel by ID

 */

@Getter
@AllArgsConstructor
public class DeleteDepartmentModelCommand {

    private DepartmentId departmentId;
}
