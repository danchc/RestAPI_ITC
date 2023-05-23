package it.itc.company_project_rest.infrastructure.service.project;

import it.itc.company_project_rest.application.command.project.GetProjectModelCommand;
import it.itc.company_project_rest.application.port.out.project.CreateProjectModelPortOut;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.jpa.mapper.project.ProjectMapper;
import it.itc.company_project_rest.infrastructure.jpa.project.ProjectJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectAdapterService implements CreateProjectModelPortOut, GetProjectModelPortOut {

    private final ProjectJpaRepository projectJpaRepository;

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
    public Optional<ProjectModel> retrieveById(ProjectId projectId) {
        return this.projectJpaRepository.findById(
                projectId.getProjectId()
        ).map(projectMapper::fromEntityToModel);
    }



}
