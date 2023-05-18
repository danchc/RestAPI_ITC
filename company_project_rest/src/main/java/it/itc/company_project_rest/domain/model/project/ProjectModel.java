package it.itc.company_project_rest.domain.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectModel {

    /* fields */

    private final ProjectId projectId;
    private String name;
    private String startDate; //SimpleDateFormat ?
    private String endDate;
}
