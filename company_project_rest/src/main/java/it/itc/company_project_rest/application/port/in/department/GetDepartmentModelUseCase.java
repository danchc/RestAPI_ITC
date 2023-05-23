package it.itc.company_project_rest.application.port.in.department;

import it.itc.company_project_rest.application.command.department.GetDepartmentModelCommand;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*

    Interface for DepartmentModel RETRIEVE Use Case

 */
@Repository
public interface GetDepartmentModelUseCase {

    Optional<DepartmentModel> getDepartmentModel(GetDepartmentModelCommand getDepartmentModelCommand);

}
