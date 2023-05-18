package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.application.mapper.project.ProjectMapper;
import it.itc.company_project_rest.application.port.in.project.CreateProjectModelUseCase;
import it.itc.company_project_rest.application.port.out.project.CreateProjectModelPortOut;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProjectModelService implements CreateProjectModelUseCase {


    private final CreateProjectModelPortOut createProjectModelPortOut;
    private ProjectMapper projectMapper = new ProjectMapper();

    @Override
    public ProjectModel createProjectModel(CreateProjectModelCommand createProjectModelCommand) {
        log.info("#### Creating new ProjectModel ####");
        ProjectModel projectModel =
                projectMapper.fromCommandToModel(createProjectModelCommand);
        log.debug("#### Requested to create {}", projectModel);
        return createProjectModelPortOut.persist(projectModel);
    }
}
