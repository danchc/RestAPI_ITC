package it.itc.company_project_rest.application.command.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*

    Command for Create new EmployeeModel

 */

@Getter
@AllArgsConstructor
public class CreateEmployeeModelCommand {

    private String name;
    private String surname;
    private String email;

}
