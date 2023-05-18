package it.itc.company_project_rest.presentation.response.project;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectResponse {

    private String name;
    private String startDate;
    private String endDate;

}
