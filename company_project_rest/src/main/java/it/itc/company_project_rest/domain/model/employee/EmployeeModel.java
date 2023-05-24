package it.itc.company_project_rest.domain.model.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.exception.EmptyField;
import it.itc.company_project_rest.domain.model.exception.InvalidObject;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Getter
@Setter
public class EmployeeModel {

    /* fields */

    private final EmployeeId employeeId;
    private String name;
    private String surname;
    private String email;
    private DepartmentModel departmentModel;
    private Set<ProjectModel> projectModelSet;

    /* builder */

    @Builder
    private EmployeeModel(EmployeeId employeeId, String name, String surname, String email, DepartmentModel departmentModel, Set<ProjectModel> projectModelSet) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departmentModel = departmentModel;
        this.projectModelSet = projectModelSet;

        /* Con questo la GET_ALL non funziona */
        validate(this);
    }

    /*
        Validate Employee E-mail
     */
    private boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        if(email != null && pat.matcher(email).matches()) {
            return true;
        } else {
            throw new EmptyField("Please insert a valid e-mail.");
        }
    }

    /*
        Validate Employee Name
     */
    private boolean validateName(String name) {
        if(name != null && !name.isEmpty()){
            return true;
        } else {
            throw new EmptyField("Please insert a valid name.");
        }
    }

    /*
        Validate Employee Surname
     */
    private boolean validateSurname(String surname) {
        if(surname != null && !surname.isEmpty()){
            return true;
        } else {
            throw new EmptyField("Please insert a valid surname.");
        }
    }

    /*
        Validate Employee
     */
    private void validate(EmployeeModel employeeModel){
        if(!(validateName(employeeModel.getName()) && validateSurname(employeeModel.getSurname()) && validateEmail(employeeModel.getEmail()))){
            throw new InvalidObject("Please insert a valid Employee.");
        }
    }


    public Set<ProjectModel> getProjectModelSet() {
        return Collections.unmodifiableSet(this.projectModelSet);
    }



}
