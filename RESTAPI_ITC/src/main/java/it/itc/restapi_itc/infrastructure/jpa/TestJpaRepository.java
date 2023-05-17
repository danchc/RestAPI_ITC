package it.itc.restapi_itc.infrastructure.jpa;

import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
    Repository che va a direttamente a dialogare con il DB implementando CRUD.
 */
@Repository
public interface TestJpaRepository extends CrudRepository<TestEntity, UUID> {

}
