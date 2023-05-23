package it.itc.company_project_rest.application.port.in.department;

import it.itc.company_project_rest.application.command.department.DeleteDepartmentModelCommand;
import org.springframework.stereotype.Repository;

/*

    Interface for DepartmentModel DELETE Use Case

 */

@Repository
public interface DeleteDepartmentModelUseCase {

    void deleteDepartmentModel(DeleteDepartmentModelCommand deleteDepartmentModelCommand);

}
