package it.itc.company_project_rest.infrastructure.jpa.department;

import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentJpaRepository extends CrudRepository<DepartmentEntity, UUID> {
}
