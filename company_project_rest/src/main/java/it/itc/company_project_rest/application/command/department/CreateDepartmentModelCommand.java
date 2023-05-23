package it.itc.company_project_rest.application.command.department;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*

    Command for Create new DepartmentModel

 */
@Getter
@AllArgsConstructor
public class CreateDepartmentModelCommand {

    private String name;

}
