package it.itc.company_project_rest.application.port.in.department;

import it.itc.company_project_rest.application.command.department.GetAllDepartmentsModelCommand;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface GetAllDepartmentModelUseCase {

    Page<DepartmentModel> retrieveAllDepartments(GetAllDepartmentsModelCommand getAllDepartmentsModelCommand);

}
