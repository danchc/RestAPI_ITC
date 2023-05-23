package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.DeleteEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.DeleteEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.employee.DeleteEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.project.DeleteProjectModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteEmployeeModelService implements DeleteEmployeeModelUseCase {

    private final DeleteEmployeeModelPortOut deleteEmployeeModelPortOut;

    @Override
    public void deleteEmployeeModel(DeleteEmployeeModelCommand deleteEmployeeModelCommand) {
        log.info("### Deleting Employee ###");
        this.deleteEmployeeModelPortOut.deleteById(
                deleteEmployeeModelCommand.getEmployeeId()
        );
    }
}
