package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.DeleteProjectModelEmployeeCommand;
import it.itc.company_project_rest.application.port.in.project.DeleteProjectModelEmployeeUseCase;
import it.itc.company_project_rest.application.port.out.project.DeleteProjectModelEmployeePortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteProjectModelEmployeeService implements DeleteProjectModelEmployeeUseCase {

    private final DeleteProjectModelEmployeePortOut deleteProjectModelEmployeePortOut;

    @Override
    public void deleteEmployee(DeleteProjectModelEmployeeCommand deleteProjectModelEmployeeCommand) {
        log.info("### Deleting Employee in Project ###");

        this.deleteProjectModelEmployeePortOut.deleteEmployee(
                deleteProjectModelEmployeeCommand.getProjectId(),
                deleteProjectModelEmployeeCommand.getEmployeeId()
        );
    }
}
