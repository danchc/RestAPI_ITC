package it.itc.company_project_rest.application.port.out.department;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllDepartmentModelPortOut {

    Page<DepartmentModel> findAll(Pageable pageable);
}
