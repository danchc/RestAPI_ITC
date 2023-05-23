package it.itc.company_project_rest.infrastructure.jpa.department;

import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentJpaRepository extends CrudRepository<DepartmentEntity, UUID> {

    @Query(value="select d from DepartmentEntity d", countQuery = "select count(d) from DepartmentEntity d")
    Page<DepartmentEntity> fetchAllDepartment(Pageable pageable);


}
