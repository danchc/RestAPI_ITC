package it.itc.company_project_rest.infrastructure.entity.employee;

import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private UUID employeeId;

    private String name;
    private String surname;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
    private Set<EmployeeProjectEntity> projectEntitySet = new HashSet<>();

    @Builder
    private EmployeeEntity(UUID employeeId, String name, String surname, String email, DepartmentEntity departmentEntity, Set<EmployeeProjectEntity> projectEntitySet){
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departmentEntity = departmentEntity;
        if(this.getProjectEntitySet() != null){
            this.projectEntitySet = projectEntitySet;
        }

    }

    public void addProject(ProjectEntity projectEntity){
        EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity(this, projectEntity);
        this.projectEntitySet.add(employeeProjectEntity);
        projectEntity.getEmployeeEntitySet().add(employeeProjectEntity);
    }

}
