package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.UpdateEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.UpdateEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.GetEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.UpdateEmployeeModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateEmployeeModelService implements UpdateEmployeeModelUseCase {

    private final UpdateEmployeeModelPortOut updateEmployeeModelPortOut;
    private final GetEmployeeModelPortOut getEmployeeModelPortOut;
    private final GetDepartmentModelPortOut getDepartmentModelPortOut;

    @Override
    public EmployeeModel updateEmployeeModel(UpdateEmployeeModelCommand updateEmployeeModelCommand) {
        log.info("### Retrieving Employee ###");

        return this.getEmployeeModelPortOut.retrieveById(
                updateEmployeeModelCommand.getEmployeeId()
        ).map(
                employeeModel -> {
                    employeeModel.setName(updateEmployeeModelCommand.getName());
                    employeeModel.setSurname(updateEmployeeModelCommand.getSurname());
                    employeeModel.setEmail(updateEmployeeModelCommand.getEmail());
                    employeeModel.setDepartmentModel(
                            getDepartmentModelPortOut.retrieveById(updateEmployeeModelCommand.getDepartmentId()).get()
                    );
                    return updateEmployeeModelPortOut.persist(employeeModel);
                }
        ).get();
    }
}
