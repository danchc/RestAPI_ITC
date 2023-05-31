package it.itc.company_project_rest.infrastructure.service.department;

import it.itc.company_project_rest.application.port.out.department.CreateDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.department.DeleteDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.department.GetAllDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.jpa.department.DepartmentJpaRepository;
import it.itc.company_project_rest.infrastructure.jpa.mapper.department.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentAdapterService implements CreateDepartmentModelPortOut, GetDepartmentModelPortOut, DeleteDepartmentModelPortOut, GetAllDepartmentModelPortOut {

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

    /* retrieve a department by id */
    @Override
    @Transactional(readOnly = true)
    public Optional<DepartmentModel> retrieveById(DepartmentId departmentId) {
        return this.departmentJpaRepository.findById(
                departmentId.getDepartmentId()
        ).map(departmentMapper::fromEntityToModel);
    }

    /* delete a department by id */
    @Override
    @Transactional
    public void deleteById(DepartmentId departmentId) {
        this.departmentJpaRepository.deleteById(
                departmentId.getDepartmentId()
        );
    }

    /* retrieve a page of departments */
    @Override
    @Transactional(readOnly = true)
    public Page<DepartmentModel> findAll(Pageable pageable) {
        Page<DepartmentEntity> departmentEntities =
                this.departmentJpaRepository.fetchAllDepartment(pageable);

        List<DepartmentModel> departmentModels =
                departmentEntities.stream().map(departmentMapper::fromEntityToModel).toList();

        return new PageImpl<>(departmentModels, pageable, departmentEntities.getTotalElements());
    }
}
