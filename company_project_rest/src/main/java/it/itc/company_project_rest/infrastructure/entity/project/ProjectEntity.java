package it.itc.company_project_rest.infrastructure.entity.project;

import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.sql.Types;
import java.util.*;

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
    public ProjectEntity(UUID projectId, String name, String startDate, String endDate){
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /* add new employee in employeeEntitySet */
    public void addEmployee(EmployeeEntity employeeEntity){
        EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity(employeeEntity, this);
        this.employeeEntitySet.add(employeeProjectEntity);
        /* mappedBy pensa ad aggiornare la lista in EmployeeEntity */
        //employeeEntity.getProjectEntitySet().add(employeeProjectEntity);
    }

    /* remove employee in employeeEntitySet */
    public void removeEmployee(EmployeeEntity employeeEntity){
        for(Iterator<EmployeeProjectEntity> it = employeeEntitySet.iterator(); it.hasNext();){
            EmployeeProjectEntity employeeProjectEntity = it.next();

            if(employeeProjectEntity.getProjectEntity().equals(this) && employeeProjectEntity.getEmployeeEntity().equals(employeeEntity)){
                it.remove();
                employeeProjectEntity.getProjectEntity().getEmployeeEntitySet().remove(employeeProjectEntity);
                employeeProjectEntity.setProjectEntity(null);
                employeeProjectEntity.setEmployeeEntity(null);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity projectEntity = (ProjectEntity) o;
        return Objects.equals(name, projectEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
