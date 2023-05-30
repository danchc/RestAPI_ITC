package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.UpdateProjectModelEmployeeCommand;
import it.itc.company_project_rest.application.port.in.project.UpdateProjectModelEmployeeUseCase;
import it.itc.company_project_rest.application.port.out.project.GetAllProjectModelPortOut;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.application.port.out.project.UpdateProjectModelEmployeePortOut;
import it.itc.company_project_rest.application.port.out.project.UpdateProjectModelPortOut;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateProjectModelEmployeeService implements UpdateProjectModelEmployeeUseCase {

    private final UpdateProjectModelEmployeePortOut updateProjectModelEmployeePortOut;
    private final GetProjectModelPortOut getProjectModelPortOut;

    @Override
    public void addEmployeeProject(UpdateProjectModelEmployeeCommand updateProjectModelEmployeeCommand) {
        log.info("### Updating Project ###");

        this.updateProjectModelEmployeePortOut.update(
                updateProjectModelEmployeeCommand.getProjectId(),
                updateProjectModelEmployeeCommand.getEmployeeId()
        );

    }
}
