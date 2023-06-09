package it.itc.company_project_rest.domain.model.project;

import it.itc.company_project_rest.domain.model.exception.EmptyField;
import it.itc.company_project_rest.domain.model.exception.NullObject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectModel {

    /* fields */

    private final ProjectId projectId;
    private String name;
    private String startDate; //SimpleDateFormat ?
    private String endDate;

    @Builder
    public ProjectModel(ProjectId projectId, String name, String startDate, String endDate){
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        //validate(this);
    }

    /*
        Validate Project Name
     */
    private boolean validateName(String name){
        if(name == null) {
            throw new NullObject("Name cannot be null.");
        } else if(name.isEmpty()) {
            throw new EmptyField("Please insert a valid project name.");
        } else {
            return true;
        }
    }

    /*
        Validate Project Date
     */

    /*
        Validate Project
     */
    private void validate(ProjectModel projectModel){
        validateName(projectModel.getName());
    }

}
