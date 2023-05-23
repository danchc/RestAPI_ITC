package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.UpdateEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.UpdateEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.GetEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.UpdateEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateEmployeeModelService implements UpdateEmployeeModelUseCase {

    /* employee */
    private final UpdateEmployeeModelPortOut updateEmployeeModelPortOut;
    private final GetEmployeeModelPortOut getEmployeeModelPortOut;

    /* department */
    private final GetDepartmentModelPortOut getDepartmentModelPortOut;

    /* project */
    private final GetProjectModelPortOut getProjectModelPortOut;

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
                    /* prova
                    * prendo l'id dal modello inserito nella request trasformata in command
                    * e lo cerco, se non esiste eccezione (?)
                    */
                    if(updateEmployeeModelCommand.getDepartmentModel() != null){
                        employeeModel.setDepartmentModel(
                                getDepartmentModelPortOut.retrieveById(
                                        updateEmployeeModelCommand.getDepartmentModel().getDepartmentId()
                                ).orElseThrow(
                                        () -> new ObjectNotFound("### DepartmentModel not found ###")
                                )
                        );
                    }
                    /* se abbiamo inserito un projectmodel */
                    if(updateEmployeeModelCommand.getProjectModel() != null) {
                        employeeModel.getProjectModelList().add(
                                getProjectModelPortOut.retrieveById(
                                        updateEmployeeModelCommand.getProjectModel().getProjectId()
                                ).orElseThrow(
                                        () -> new ObjectNotFound("### ProjectModel not found ###")
                                )
                        );
                    }

                    return updateEmployeeModelPortOut.persist(employeeModel);
                }
        ).get();
    }
}
