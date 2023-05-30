package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.UpdateProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.UpdateProjectModelUseCase;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.application.port.out.project.UpdateProjectModelPortOut;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateProjectModelService implements UpdateProjectModelUseCase {

    private final GetProjectModelPortOut getProjectModelPortOut;
    private final UpdateProjectModelPortOut updateProjectModelPortOut;

    @Override
    public ProjectModel updateProjectModel(UpdateProjectModelCommand updateProjectModelCommand) {
        log.info("### Retrieving ProjectModel ###");

        Optional<ProjectModel> projectRetrieved =
                this.getProjectModelPortOut.retrieveById(
                        updateProjectModelCommand.getProjectId()
                );

        if(projectRetrieved.isPresent()) {
            return updateProjectModelPortOut.persist(
                    ProjectModel.builder()
                            .projectId(updateProjectModelCommand.getProjectId())
                            .name(updateProjectModelCommand.getName())
                            .startDate(updateProjectModelCommand.getStartDate())
                            .endDate(updateProjectModelCommand.getEndDate())
                            .build()
            );
        } else {
            throw new ObjectNotFound("Project not found.");
        }
    }
}
