package it.itc.company_project_rest.infrastructure.jpa.employee;

import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends CrudRepository<EmployeeEntity, UUID> {

    @Query(value="select e from EmployeeEntity e", countQuery = "select count(e) from EmployeeEntity e")
    Page<EmployeeEntity> fetchAllEmployee(Pageable pageable);




}
