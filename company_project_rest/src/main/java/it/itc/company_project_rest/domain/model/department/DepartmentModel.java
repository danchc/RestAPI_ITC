package it.itc.company_project_rest.domain.model.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentModel {

    /* fields */

    private final DepartmentId departmentId;
    private String name;
}
