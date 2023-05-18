package it.itc.company_project_rest.presentation.request.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String name;
    private String surname;
    private String email;

}
