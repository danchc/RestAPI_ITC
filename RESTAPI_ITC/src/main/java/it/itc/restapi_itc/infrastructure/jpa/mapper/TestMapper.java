package it.itc.restapi_itc.infrastructure.jpa.mapper;

import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;

import java.util.UUID;

/*
    Mapper al livello più basso per mappare da TestModel a TestEntity e viceversa.
 */
public class TestMapper {

    /* metodo per la mappatura */
    public TestEntity fromModelToEntity(TestModel testModel){
        return new TestEntity(
                testModel.getTestId().getTestId(),
                testModel.getPhrase()
        );
    }

    /* metodo per la mappatura */
    public TestModel fromEntityToModel(TestEntity testEntity){
        return new TestModel(
                new TestId(testEntity.getTestId()),
                testEntity.getPhrase()
        );
    }

}
