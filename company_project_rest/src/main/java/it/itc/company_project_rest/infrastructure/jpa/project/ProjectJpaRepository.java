package it.itc.company_project_rest.infrastructure.jpa.project;

import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectJpaRepository extends CrudRepository<ProjectEntity, UUID> {

    @Query(value="select p from ProjectEntity p", countQuery = "select count(p) from ProjectEntity p")
    Page<ProjectEntity> fetchAllProject(Pageable pageable);

}
