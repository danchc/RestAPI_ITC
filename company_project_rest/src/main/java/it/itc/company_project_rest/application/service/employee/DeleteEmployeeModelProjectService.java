package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.DeleteEmployeeModelProjectCommand;
import it.itc.company_project_rest.application.port.in.employee.DeleteEmployeeModelProjectUseCase;
import it.itc.company_project_rest.application.port.out.employee.DeleteEmployeeModelProjectPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteEmployeeModelProjectService implements DeleteEmployeeModelProjectUseCase {

    private final DeleteEmployeeModelProjectPortOut deleteEmployeeModelProjectPortOut;

    @Override
    public void deleteProject(DeleteEmployeeModelProjectCommand deleteEmployeeModelProjectCommand) {
        log.info("### Deleting Project in Employee ###");

        this.deleteEmployeeModelProjectPortOut.deleteProject(
                deleteEmployeeModelProjectCommand.getEmployeeId(),
                deleteEmployeeModelProjectCommand.getProjectId()
        );
    }
}
