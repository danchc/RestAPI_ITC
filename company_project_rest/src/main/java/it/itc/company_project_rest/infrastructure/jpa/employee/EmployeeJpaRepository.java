package it.itc.company_project_rest.infrastructure.jpa.employee;

import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends CrudRepository<EmployeeEntity, UUID> {
}
