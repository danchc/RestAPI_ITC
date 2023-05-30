package it.itc.company_project_rest.infrastructure.service.project;

import it.itc.company_project_rest.application.port.out.project.*;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import it.itc.company_project_rest.infrastructure.jpa.employee.EmployeeJpaRepository;
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
public class ProjectAdapterService
        implements CreateProjectModelPortOut, GetProjectModelPortOut, DeleteProjectModelPortOut, GetAllProjectModelPortOut, UpdateProjectModelPortOut, UpdateProjectModelEmployeePortOut{

    private final ProjectJpaRepository projectJpaRepository;
    private final EmployeeJpaRepository employeeJpaRepository;

    private final ProjectMapper projectMapper = new ProjectMapper();

    /* Metodo per salvare un progetto */
    @Override
    @Transactional
    public ProjectModel persist(ProjectModel projectModel) {
        this.projectJpaRepository.save(
                this.projectMapper.fromModelToEntity(projectModel)
        );
        return projectModel;
    }

    /* Metodo per cercare un progetto */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProjectModel> retrieveById(ProjectId projectId) {
        return this.projectJpaRepository.findById(
                projectId.getProjectId()
        ).map(projectMapper::fromEntityToModel);
    }


    @Override
    @Transactional
    public void deleteById(ProjectId projectId) {
        this.projectJpaRepository.deleteById(
                projectId.getProjectId()
        );
    }


    @Override
    @Transactional(readOnly = true)
    public Page<ProjectModel> findAll(Pageable pageable) {
        Page<ProjectEntity> projectEntityPage =
                this.projectJpaRepository.fetchAllProject(pageable);

        List<ProjectModel> projectModelList =
                projectEntityPage.stream().map(this.projectMapper::fromEntityToModel).toList();

        return new PageImpl<>(projectModelList, pageable, projectEntityPage.getTotalElements());
    }
    @Override
    @Transactional
    public void update(ProjectId projectId, EmployeeId employeeId) {

        EmployeeEntity employeeEntity =
                this.employeeJpaRepository.findById(employeeId.getEmployeeId()).orElseThrow(
                        () -> new ObjectNotFound("Employee not found.")
                );

        ProjectEntity projectEntity =
                this.projectJpaRepository.findById(projectId.getProjectId()).orElseThrow(
                        () -> new ObjectNotFound("Project not found.")
                );

        projectEntity.addEmployee(employeeEntity);
        this.projectJpaRepository.save(projectEntity);

    }


}
