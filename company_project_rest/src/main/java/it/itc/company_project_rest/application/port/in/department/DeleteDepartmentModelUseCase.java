package it.itc.company_project_rest.application.port.in.department;

import it.itc.company_project_rest.application.command.department.DeleteDepartmentModelCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteDepartmentModelUseCase {

    void deleteDepartmentModel(DeleteDepartmentModelCommand deleteDepartmentModelCommand);

}
