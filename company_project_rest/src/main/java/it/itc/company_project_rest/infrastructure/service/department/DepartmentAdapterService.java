package it.itc.company_project_rest.infrastructure.service.department;

import it.itc.company_project_rest.application.port.out.department.CreateDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.department.DeleteDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.infrastructure.jpa.department.DepartmentJpaRepository;
import it.itc.company_project_rest.infrastructure.jpa.mapper.department.DepartmentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentAdapterService implements CreateDepartmentModelPortOut, GetDepartmentModelPortOut, DeleteDepartmentModelPortOut {

    private final DepartmentJpaRepository departmentJpaRepository;

    private final DepartmentMapper departmentMapper = new DepartmentMapper();

    /* metodo per il salvataggio di un nuovo DepartmentModel nel db */
    @Override
    @Transactional
    public DepartmentModel persist(DepartmentModel departmentModel) {
        this.departmentJpaRepository.save(
                this.departmentMapper.fromModelToEntity(departmentModel)
        );

        return departmentModel;
    }

    @Override
    public Optional<DepartmentModel> retrieveById(DepartmentId departmentId) {
        return this.departmentJpaRepository.findById(
                departmentId.getDepartmentId()
        ).map(departmentMapper::fromEntityToModel);
    }

    @Override
    @Transactional
    public void deleteById(DepartmentId departmentId) {
        this.departmentJpaRepository.deleteById(
                departmentId.getDepartmentId()
        );
    }
}
