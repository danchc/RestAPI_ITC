package it.itc.company_project_rest.application.service.employee;


import it.itc.company_project_rest.application.command.employee.CreateEmployeeModelCommand;
import it.itc.company_project_rest.application.mapper.employee.EmployeeMapper;
import it.itc.company_project_rest.application.port.in.employee.CreateEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.employee.CreateEmployeeModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateEmployeeModelService implements CreateEmployeeModelUseCase {

    private final CreateEmployeeModelPortOut createEmployeeModelPortOut;
    private EmployeeMapper employeeMapper = new EmployeeMapper();


    @Override
    public EmployeeModel createEmployeeModel(CreateEmployeeModelCommand createEmployeeModelCommand) {
        log.info("#### Creating EmployeeModel ####");
        EmployeeModel employeeModel =
                this.employeeMapper.fromCommandToModel(createEmployeeModelCommand);
        log.debug("#### Creating EmployeeModel {} ", employeeModel);

        return this.createEmployeeModelPortOut.persist(employeeModel);
    }
}
