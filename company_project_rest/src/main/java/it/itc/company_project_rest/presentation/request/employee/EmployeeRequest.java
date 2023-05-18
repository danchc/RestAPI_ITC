package it.itc.company_project_rest.presentation.request.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeRequest {

    private String name;
    private String surname;
    private String email;

}
