package it.itc.company_project_rest.application.command.employee;


import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartmentEmployeeModelCommand {

    private EmployeeId employeeId;
    private DepartmentId departmentId;


}
