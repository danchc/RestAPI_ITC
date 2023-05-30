package it.itc.company_project_rest.infrastructure.service.employee;

import it.itc.company_project_rest.application.port.out.employee.*;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import it.itc.company_project_rest.infrastructure.jpa.employee.EmployeeJpaRepository;
import it.itc.company_project_rest.infrastructure.jpa.mapper.employee.EmployeeMapper;
import it.itc.company_project_rest.infrastructure.jpa.mapper.project.ProjectMapper;
import it.itc.company_project_rest.infrastructure.jpa.project.ProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CreateEmployeeModelPortOut, GetEmployeeModelPortOut, UpdateEmployeeModelPortOut, DeleteEmployeeModelPortOut, GetAllEmployeeModelPortOut {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final ProjectJpaRepository projectJpaRepository;
    private final EmployeeMapper employeeMapper = new EmployeeMapper();
    private final ProjectMapper projectMapper = new ProjectMapper();
    @Override
    @Transactional
    public EmployeeModel persist(EmployeeModel employeeModel) {
        this.employeeJpaRepository.save(
            this.employeeMapper.fromModelToEntity(employeeModel)
        );
        return employeeModel;
    }

    @Override
    @Transactional
    public void update(EmployeeId employeeId, ProjectId projectId) {
        EmployeeEntity employeeEntity = this.employeeJpaRepository.findById(employeeId.getEmployeeId()).orElseThrow(
                ()-> new ObjectNotFound("Employee not found")
        );
        ProjectEntity projectEntity = this.projectJpaRepository.findById(projectId.getProjectId()).orElseThrow(
                () -> new ObjectNotFound("Project not found")
        );
        employeeEntity.addProject(projectEntity);

        employeeJpaRepository.save(this.employeeJpaRepository.findById(employeeId.getEmployeeId()).get());
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public Page<EmployeeModel> findAll(Pageable pageable) {

        Page<EmployeeEntity> employeeEntityPage = this.employeeJpaRepository.fetchAllEmployee(pageable);

        List<EmployeeModel> employeeModelList = employeeEntityPage.stream().map(employeeMapper::fromEntityToModel).toList();

        return new PageImpl<>(employeeModelList, pageable, employeeEntityPage.getTotalElements());
    }



}
