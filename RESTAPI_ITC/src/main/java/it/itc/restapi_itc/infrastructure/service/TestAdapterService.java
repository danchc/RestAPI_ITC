package it.itc.restapi_itc.infrastructure.service;

import it.itc.restapi_itc.application.port.out.CreateTestModelPortOut;
import it.itc.restapi_itc.application.port.out.GetTestModelPortOut;
import it.itc.restapi_itc.domain.model.TestId;
import it.itc.restapi_itc.domain.model.TestModel;
import it.itc.restapi_itc.infrastructure.entity.TestEntity;
import it.itc.restapi_itc.infrastructure.jpa.TestJpaRepository;
import it.itc.restapi_itc.infrastructure.jpa.mapper.TestMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestAdapterService implements CreateTestModelPortOut, GetTestModelPortOut {

    private final TestJpaRepository testJpaRepository;

    private final TestMapper testMapper = new TestMapper();

    /*
        Questo metodo salva direttamente l'entità nel DB.
     */
    @Override
    @Transactional
    public TestModel persist(TestModel testModel) {
        //salvo l'entità nel db
        testJpaRepository.save(testMapper.fromModelToEntity(testModel));
        return testModel;
    }


    @Override
    @Transactional
    public Optional<TestModel> findById(TestId testId) {
       return testJpaRepository.findById(testId.getTestId()).map(testMapper::fromEntityToModel);
    }
}
