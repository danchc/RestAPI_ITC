package it.itc.company_project_rest.infrastructure.service.employee;

import it.itc.company_project_rest.application.port.out.employee.CreateEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.DeleteEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.GetEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.UpdateEmployeeModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.jpa.employee.EmployeeJpaRepository;
import it.itc.company_project_rest.infrastructure.jpa.mapper.employee.EmployeeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CreateEmployeeModelPortOut, GetEmployeeModelPortOut, UpdateEmployeeModelPortOut, DeleteEmployeeModelPortOut {

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
}
