package it.itc.company_project_rest.application.port.out.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/*

    Porting Out RETRIEVE_ALL Interface for EmployeeModel

 */

public interface GetAllEmployeeModelPortOut {

    Page<EmployeeModel> findAll(Pageable pageable);

}
