package it.itc.company_project_rest.presentation.mapper.department;


/*

    Mapping class for Department

 */

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.presentation.request.department.DepartmentRequest;
import it.itc.company_project_rest.presentation.response.department.DepartmentResponse;

public class DepartmentMapper {

    /* fromRequestToCommand */
    public CreateDepartmentModelCommand fromRequestToCommand(DepartmentRequest departmentRequest) {
        return new CreateDepartmentModelCommand(
                departmentRequest.getName()
        );
    }

    /* fromModelToResponse */
    public DepartmentResponse fromModelToResponse(DepartmentModel departmentModel){
        return new DepartmentResponse(
                departmentModel.getName()
        );
    }

}
