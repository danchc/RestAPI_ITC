package it.itc.company_project_rest.infrastructure.jpa.project;

import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectJpaRepository extends CrudRepository<ProjectEntity, UUID> {
}
