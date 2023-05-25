package it.itc.company_project_rest.domain.model.department;

import it.itc.company_project_rest.domain.model.exception.EmptyField;
import it.itc.company_project_rest.domain.model.exception.NullObject;
import lombok.*;

@Getter
@Setter
public class DepartmentModel {

    /* fields */
    private final DepartmentId departmentId;
    private final String name;

    @Builder
    public DepartmentModel(DepartmentId departmentId, String name){
        this.departmentId = departmentId;
        this.name = name;
        validate(this);
    }

    /*
        Validate Department Name
     */
    private boolean validateName(String name){
        if(name == null) {
            throw new NullObject("Name cannot be null.");
        } else if(name.isEmpty()) {
            throw new EmptyField("Please insert a valid department name.");
        } else {
            return true;
        }
    }

    /*
        Validate Department
     */
    private void validate(DepartmentModel departmentModel){
        validateName(departmentModel.getName());
    }
}