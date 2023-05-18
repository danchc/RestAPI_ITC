package it.itc.company_project_rest.infrastructure.entity.employee;

import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "employee")
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private UUID employeeId;

    private String name;
    private String surname;
    private String email;

    @ManyToOne
    private DepartmentEntity departmentEntity;

    @OneToMany
    private List<ProjectEntity> projectEntityList;

    @Builder
    private EmployeeEntity(UUID employeeId, String name, String surname, String email, DepartmentEntity departmentEntity, List<ProjectEntity> projectEntityList){
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departmentEntity = departmentEntity;
        this.projectEntityList = projectEntityList;
    }

}
