package it.itc.company_project_rest.infrastructure.entity.employee_project;


import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Objects;

@Entity(name = "EmployeeProject")
@Table(name = "employee_project")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeProjectEntity {

    @EmbeddedId
    private EmployeeProjectId employeeProjectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("employeeId")
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("projectId")
    private ProjectEntity projectEntity;


    @Builder
    public EmployeeProjectEntity(EmployeeEntity employeeEntity, ProjectEntity projectEntity){
        this.employeeEntity = employeeEntity;
        this.projectEntity = projectEntity;
        this.employeeProjectId = new EmployeeProjectId(employeeEntity.getEmployeeId(), projectEntity.getProjectId());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        EmployeeProjectEntity that = (EmployeeProjectEntity) o;
        return  Objects.equals(employeeEntity, that.employeeEntity) &&
                Objects.equals(projectEntity, that.projectEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeEntity, projectEntity);
    }


}
