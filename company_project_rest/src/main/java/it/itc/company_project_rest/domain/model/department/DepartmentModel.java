package it.itc.company_project_rest.domain.model.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

    /* fields */
    private DepartmentId departmentId;
    private String name;
}
