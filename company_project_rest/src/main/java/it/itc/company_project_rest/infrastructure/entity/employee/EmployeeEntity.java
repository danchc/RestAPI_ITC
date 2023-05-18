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
@AllArgsConstructor
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

}
