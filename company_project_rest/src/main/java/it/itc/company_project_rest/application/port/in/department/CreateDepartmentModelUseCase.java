package it.itc.company_project_rest.application.port.in.department;

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import org.springframework.stereotype.Repository;

/*

    Interface for DepartmentModel CREATE Use Case

 */


@Repository
public interface CreateDepartmentModelUseCase {

    DepartmentModel createDepartmentModel(CreateDepartmentModelCommand createDepartmentModelCommand);


}
