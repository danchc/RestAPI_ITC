package it.itc.company_project_rest.domain.model.department;

import it.itc.company_project_rest.domain.model.exception.EmptyField;
import it.itc.company_project_rest.domain.model.exception.NullObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DepartmentModel {

    /* fields */
    private final DepartmentId departmentId;
    private String name;

    public DepartmentModel(DepartmentId departmentId, String name){
        this.departmentId = departmentId;
        if(validateName(name)){
            this.name = name;
        }
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
}
