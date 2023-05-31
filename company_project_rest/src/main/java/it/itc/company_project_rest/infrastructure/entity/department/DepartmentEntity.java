package it.itc.company_project_rest.infrastructure.entity.department;

import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "department")
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue
    private UUID departmentId;

    private String name;

    @OneToMany(mappedBy = "departmentEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EmployeeEntity> employeeEntitySet = new HashSet<>();

    @Builder
    public DepartmentEntity(UUID departmentId, String name, Set<EmployeeEntity> employeeEntitySet){
        this.departmentId = departmentId;
        this.name = name;
        this.employeeEntitySet = employeeEntitySet;
    }

}