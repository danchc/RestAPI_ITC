package it.itc.company_project_rest.infrastructure.entity.employee;

import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EmployeeProjectEntity> projectEntitySet = new HashSet<>();

    @Builder
    private EmployeeEntity(UUID employeeId, String name, String surname, String email, DepartmentEntity departmentEntity){
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departmentEntity = departmentEntity;

    }


    /* add new project in Set<EmployeeProjectEntity> */
    public void addProject(ProjectEntity projectEntity){
        EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity(this, projectEntity);
        this.projectEntitySet.add(employeeProjectEntity);
        //projectEntity.getEmployeeEntitySet().add(employeeProjectEntity);
    }

    /* remove project in Set<EmployeeProjectEntity> */
    public void removeProject(ProjectEntity projectEntity){
        for(Iterator<EmployeeProjectEntity> it = projectEntitySet.iterator(); it.hasNext();){
            EmployeeProjectEntity employeeProjectEntity = it.next();

            if(employeeProjectEntity.getEmployeeEntity().equals(this) && employeeProjectEntity.getProjectEntity().equals(projectEntity)) {
                it.remove();
                employeeProjectEntity.getProjectEntity().getEmployeeEntitySet().remove(employeeProjectEntity);
                employeeProjectEntity.setEmployeeEntity(null);
                employeeProjectEntity.setProjectEntity(null);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity)) return false;
        return employeeId != null && employeeId.equals(((EmployeeEntity) o).getEmployeeId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}
