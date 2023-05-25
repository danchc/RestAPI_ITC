package it.itc.company_project_rest.infrastructure.entity.employee_project;


import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "EmployeeProject")
@Table(name = "employee_project")
@NoArgsConstructor
public class EmployeeProjectEntity {

    @EmbeddedId
    private EmployeeProjectId employeeProjectId;

    @ManyToOne
    @MapsId("employeeId")
    private EmployeeEntity employeeEntity;

    @ManyToOne
    @MapsId("projectId")
    private ProjectEntity projectEntity;


    @Builder
    public EmployeeProjectEntity(EmployeeEntity employeeEntity, ProjectEntity projectEntity){
        this.employeeEntity = employeeEntity;
        this.projectEntity = projectEntity;
        this.employeeProjectId = new EmployeeProjectId(employeeEntity.getEmployeeId(), projectEntity.getProjectId());
    }


}
