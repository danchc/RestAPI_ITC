package it.itc.company_project_rest.infrastructure.entity.project;

import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "project")
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue
    private UUID projectId;

    private String name;
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeProjectEntity> employeeEntitySet = new HashSet<>();

    @Builder
    public ProjectEntity(UUID projectId, String name, String startDate, String endDate, Set<EmployeeProjectEntity> employeeEntitySet){
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        if(employeeEntitySet != null){
            this.employeeEntitySet = employeeEntitySet;
        }

    }

}
