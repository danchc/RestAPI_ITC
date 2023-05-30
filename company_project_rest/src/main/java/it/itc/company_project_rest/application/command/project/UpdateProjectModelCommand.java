package it.itc.company_project_rest.application.command.project;

import it.itc.company_project_rest.domain.model.project.ProjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjectModelCommand {

    private ProjectId projectId;
    private String name;
    private String startDate;
    private String endDate;
}
