package it.itc.company_project_rest.application.mapper.department;


/*

    Mapping class for Department

 */

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;

import java.util.UUID;

public class DepartmentMapper {

    /* fromCommandToModel */
    public DepartmentModel fromCommandToModel(CreateDepartmentModelCommand createDepartmentModelCommand) {
        return DepartmentModel.builder()
                .departmentId(new DepartmentId(UUID.randomUUID()))
                .name(createDepartmentModelCommand.getName())
                .build();
    }


}
