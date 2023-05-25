package it.itc.company_project_rest.domain.model.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.exception.*;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Getter
@Setter
public class EmployeeModel {

    /* fields */

    private final EmployeeId employeeId;
    private final String name;
    private final String surname;
    private final String email;
    private DepartmentModel departmentModel;
    private Set<ProjectModel> projectModelSet = new HashSet<>();

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

        if(email == null) {
            throw new NullObject("E-mail cannot be null.");
        } else if (email.isEmpty()){
            throw new EmptyField("Please insert a valid e-mail.");
        } else {
            return pat.matcher(email).matches();
        }
    }

    /*
        Validate Employee Name
     */
    private boolean validateName(String name) {
        if(name == null) {
            throw new NullObject("Name cannot be null.");
        } else if(name.isEmpty()) {
            throw new EmptyField("Please insert a valid Employee name.");
        } else {
            return true;
        }
    }

    /*
        Validate Employee Surname
     */
    private boolean validateSurname(String surname) {
        if(surname == null) {
            throw new NullObject("Surname cannot be null.");
        } else if(surname.isEmpty()) {
            throw new EmptyField("Please insert a valid Employee surname.");
        } else {
            return true;
        }
    }

    /*
        Validate Employee
     */
    private void validate(EmployeeModel employeeModel){
        validateName(employeeModel.getName());
        validateSurname(employeeModel.getSurname());
        validateEmail(employeeModel.getEmail());
    }

    /*
        Metodo per recuperare il Set di ProjectModel
     */
    public Set<ProjectModel> getProjectModelSet() {
        return Collections.unmodifiableSet(this.projectModelSet);
    }

    /*
        Metodo per aggiungere un nuovo progetto alla lista dell'Employee
     */
    public void addNewProject(ProjectModel projectModel){
        if (projectModel == null) {
            throw new NullObject("Project cannot be null.");
        }
        if (this.projectModelSet.contains(projectModel)){
            throw new AlreadyExists("This project is already assigned to Employee.");
        }
        this.projectModelSet.add(projectModel);
    }

    /*
        Metodo per rimuovere un progetto dalla lista dell'Employee
     */
    public void removeProject(ProjectModel projectModel){
        if (projectModel == null) {
            throw new NullObject("Project cannot be null.");
        }
        if (!this.projectModelSet.contains(projectModel)){
            throw new ObjectNotFound("Employee is not working on this project.");
        }
        this.projectModelSet.remove(projectModel);
    }

    /*
        metodi per assegnazione e dissociazione di dipartimento, progetto
     */
    public void setDepartmentModel(DepartmentModel dep){
        if(dep == null) {
            throw new NullObject("Department cannot be null.");
        } else {
            this.departmentModel = dep;
        }
    }

}