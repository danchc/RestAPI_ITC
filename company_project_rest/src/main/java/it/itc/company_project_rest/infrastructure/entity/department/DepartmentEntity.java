package it.itc.company_project_rest.infrastructure.entity.department;

import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue
    private UUID departmentId;

    private String name;

}
