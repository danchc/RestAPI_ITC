package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.CreateProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.CreateProjectModelUseCase;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProjectModelService implements CreateProjectModelUseCase {


    @Override
    public ProjectModel persist(CreateProjectModelCommand createProjectModelCommand) {
        
    }
}
