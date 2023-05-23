package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.GetProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.GetProjectModelUseCase;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetProjectModelService implements GetProjectModelUseCase {

    private final GetProjectModelPortOut getProjectModelPortOut;

    @Override
    public Optional<ProjectModel> retrieveProjectModel(GetProjectModelCommand getProjectModelCommand) {
        log.info("#### Retrieving ProjectModel #####");
        return this.getProjectModelPortOut.retrieveById(
                getProjectModelCommand.getProjectId()
        );
    }
}
