package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.UpdateDepartmentEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateProjectListEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.UpdateEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.GetEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.employee.UpdateEmployeeModelPortOut;
import it.itc.company_project_rest.application.port.out.project.GetProjectModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.exception.ObjectNotFound;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

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


    /* Update Employee with new name, surname or email */
    @Override
    public EmployeeModel updateEmployeeModel(UpdateEmployeeModelCommand updateEmployeeModelCommand) {
        log.info("### Retrieving Employee ###");

        Optional<EmployeeModel> employeeRetrieved =
                this.getEmployeeModelPortOut.retrieveById(
                        updateEmployeeModelCommand.getEmployeeId()
                );

        if(employeeRetrieved.isPresent()){

            return updateEmployeeModelPortOut.persist(
                    EmployeeModel.builder()
                            .employeeId(employeeRetrieved.get().getEmployeeId())
                            .name(updateEmployeeModelCommand.getName())
                            .surname(updateEmployeeModelCommand.getSurname())
                            .email(updateEmployeeModelCommand.getEmail())
                            .build()
            );
        } else {
            throw new ObjectNotFound("Employee not found.");
        }
    }

    /* Update Employee with new Department */
    @Override
    public EmployeeModel updateDepartmentEmployeeModel(UpdateDepartmentEmployeeModelCommand updateDepartmentEmployeeModelCommand) {
        log.info("### Retrieving Employee ###");

        Optional<EmployeeModel> employeeRetrieved =
                this.getEmployeeModelPortOut.retrieveById(
                        updateDepartmentEmployeeModelCommand.getEmployeeId()
                );

        if(employeeRetrieved.isPresent()){
            employeeRetrieved.get().setDepartmentModel(
                    getDepartmentModelPortOut.retrieveById(
                            updateDepartmentEmployeeModelCommand.getDepartmentId()
                    ).orElseThrow(
                            () -> new ObjectNotFound("### DepartmentModel not found ###")
                    )
            );

            return this.updateEmployeeModelPortOut.persist(employeeRetrieved.get());
        } else {
            throw new ObjectNotFound("Employee not found.");
        }


    }

    /* Update Employee with new Project in Project List */
    @Override
    public EmployeeModel updateProjectListEmployeeModel(UpdateProjectListEmployeeModelCommand updateProjectListEmployeeModelCommand) {
        log.info("### Retrieving EmployeeModel ###");

        Optional<EmployeeModel> employeeRetrieved =
                this.getEmployeeModelPortOut.retrieveById(
                        updateProjectListEmployeeModelCommand.getEmployeeId()
                );
        if(employeeRetrieved.isPresent()){
            employeeRetrieved.get().addNewProject(
                    this.getProjectModelPortOut.retrieveById(
                            updateProjectListEmployeeModelCommand.getProjectId()
                    ).orElseThrow(
                            () -> new ObjectNotFound("### ProjectModel Not Found ###")
                    )
            );
            return this.updateEmployeeModelPortOut.persist(employeeRetrieved.get());
        } else {
            throw new ObjectNotFound("Employee not found.");
        }
    }
}
