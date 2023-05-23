package it.itc.company_project_rest.infrastructure.service.employee;

import it.itc.company_project_rest.application.port.out.employee.*;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.jpa.employee.EmployeeJpaRepository;
import it.itc.company_project_rest.infrastructure.jpa.mapper.employee.EmployeeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CreateEmployeeModelPortOut, GetEmployeeModelPortOut, UpdateEmployeeModelPortOut, DeleteEmployeeModelPortOut, GetAllEmployeeModelPortOut {

    private final EmployeeJpaRepository employeeJpaRepository;
    private EmployeeMapper employeeMapper = new EmployeeMapper();

    @Override
    @Transactional
    public EmployeeModel persist(EmployeeModel employeeModel) {
        this.employeeJpaRepository.save(
            this.employeeMapper.fromModelToEntity(employeeModel)
        );

        return employeeModel;
    }

    @Override
    public Optional<EmployeeModel> retrieveById(EmployeeId employeeId) {
        return this.employeeJpaRepository.findById(
                employeeId.getEmployeeId()
        ).map(employeeMapper::fromEntityToModel);
    }

    @Override
    @Transactional
    public void deleteById(EmployeeId employeeId) {
        this.employeeJpaRepository.deleteById(
                employeeId.getEmployeeId()
        );
    }


    @Override
    public Page<EmployeeModel> findAll(Pageable pageable) {

        Page<EmployeeEntity> employeeEntityPage = this.employeeJpaRepository.fetchAllEmployee(pageable);

        List<EmployeeModel> employeeModelList = employeeEntityPage.stream().map(employeeMapper::fromEntityToModel).toList();

        return new PageImpl<>(employeeModelList, pageable, employeeEntityPage.getTotalElements());
    }
}
