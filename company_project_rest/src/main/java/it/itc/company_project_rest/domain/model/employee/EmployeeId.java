package it.itc.company_project_rest.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EmployeeId {

    private final UUID employeeId;

    public EmployeeId(UUID employeeId){
        this.employeeId = employeeId;
    }
}
