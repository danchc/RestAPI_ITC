package it.itc.company_project_rest.application.port.out.employee;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;

/*

    Porting Out DELETE Interface for EmployeeModel

 */
public interface DeleteEmployeeModelPortOut {

    void deleteById(EmployeeId employeeId);
}
