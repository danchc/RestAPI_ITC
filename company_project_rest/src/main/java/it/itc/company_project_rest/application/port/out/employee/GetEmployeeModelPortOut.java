package it.itc.company_project_rest.application.port.out.employee;


import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;

import java.util.Optional;

public interface GetEmployeeModelPortOut {

    Optional<EmployeeModel> retrieveById(EmployeeId employeeId);

}
