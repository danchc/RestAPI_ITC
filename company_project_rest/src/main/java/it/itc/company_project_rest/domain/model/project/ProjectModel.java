package it.itc.company_project_rest.domain.model.project;

import it.itc.company_project_rest.domain.model.exception.EmptyField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectModel {

    /* fields */

    private ProjectId projectId;
    private String name;
    private String startDate; //SimpleDateFormat ?
    private String endDate;

    public ProjectModel(ProjectId projectId, String name, String startDate, String endDate){
        this.projectId = projectId;
        if(validateName(name)){
            this.name = name;
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /*
        Validate Project Name
     */
    private boolean validateName(String name){
        if(name != null && !name.isEmpty()){
            return true;
        } else {
            throw new EmptyField("Please insert a valid project name.");
        }
    }

    /*
        Validate Project Date
     */

}
