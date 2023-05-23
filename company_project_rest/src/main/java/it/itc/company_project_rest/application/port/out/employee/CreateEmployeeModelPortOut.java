package it.itc.company_project_rest.application.port.out.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeModel;

/*

    Porting Out CREATE Interface for EmployeeModel

 */

public interface CreateEmployeeModelPortOut {

    EmployeeModel persist(EmployeeModel employeeModel);

}
