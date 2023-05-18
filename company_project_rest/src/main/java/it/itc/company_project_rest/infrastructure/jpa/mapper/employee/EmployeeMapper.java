package it.itc.company_project_rest.infrastructure.jpa.mapper.employee;

/*

    Mapping Class for Employee

 */


import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;

public class EmployeeMapper {

    /* fromModelToEntity */
    public EmployeeEntity fromModelToEntity(EmployeeModel employeeModel){
        return EmployeeEntity.builder()
                .employeeId(employeeModel.getEmployeeId().getEmployeeId())
                .email(employeeModel.getEmail())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname()).build();
    }

    /* fromEntityToModel */
    public EmployeeModel fromEntityToModel(EmployeeEntity employeeEntity){
        return EmployeeModel.builder()
                .employeeId(new EmployeeId(employeeEntity.getEmployeeId()))
                .email(employeeEntity.getEmail())
                .name(employeeEntity.getName())
                .surname(employeeEntity.getSurname()).build();
    }

}
