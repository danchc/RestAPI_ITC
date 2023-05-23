package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.DeleteProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.DeleteProjectModelUseCase;
import it.itc.company_project_rest.application.port.out.project.DeleteProjectModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteProjectModelService implements DeleteProjectModelUseCase {

    private final DeleteProjectModelPortOut deleteProjectModelPortOut;

    @Override
    public void deleteProjectModel(DeleteProjectModelCommand deleteProjectModelCommand) {
        log.info("### Deleting Project Model ###");

        deleteProjectModelPortOut.deleteById(
                deleteProjectModelCommand.getProjectId()
        );

    }
}
