package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.GetEmployeeModelCommand;
import it.itc.company_project_rest.application.mapper.employee.EmployeeMapper;
import it.itc.company_project_rest.application.port.in.employee.GetEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.employee.GetEmployeeModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetEmployeeModelService implements GetEmployeeModelUseCase {

    private final GetEmployeeModelPortOut getEmployeeModelPortOut;

    @Override
    public Optional<EmployeeModel> retrieveEmployee(GetEmployeeModelCommand getEmployeeModelCommand) {
        log.info("### Retrieving Employee ###");
        return this.getEmployeeModelPortOut.retrieveById(
                getEmployeeModelCommand.getEmployeeId()
        );
    }
}
