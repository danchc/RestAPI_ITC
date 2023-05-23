package it.itc.company_project_rest.application.command.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*

    Command for Retrieve DepartmentModel Page

 */

@Getter
@AllArgsConstructor
public class GetAllEmployeeModelCommand {

    private final int size;
    private final int page;
}
