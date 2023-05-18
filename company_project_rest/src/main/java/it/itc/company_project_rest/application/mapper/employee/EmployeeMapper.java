package it.itc.company_project_rest.application.mapper.employee;

import it.itc.company_project_rest.application.command.employee.CreateEmployeeModelCommand;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;

import java.util.UUID;

/*
    Mapping Class for Employee
 */
public class EmployeeMapper {

    /* fromCommandToModel */
    public EmployeeModel fromCommandToModel(CreateEmployeeModelCommand createEmployeeModelCommand){
        return EmployeeModel.builder()
                .employeeId(new EmployeeId(UUID.randomUUID()))
                .name(createEmployeeModelCommand.getName())
                .surname(createEmployeeModelCommand.getSurname())
                .email(createEmployeeModelCommand.getEmail())
                .build();
    }

}
