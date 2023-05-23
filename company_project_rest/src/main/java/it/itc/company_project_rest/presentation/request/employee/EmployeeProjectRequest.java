package it.itc.company_project_rest.presentation.request.employee;

import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectRequest {

    private ProjectId projectId;
}
