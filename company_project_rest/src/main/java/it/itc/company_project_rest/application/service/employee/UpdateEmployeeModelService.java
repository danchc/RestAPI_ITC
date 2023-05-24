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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

        return this.getEmployeeModelPortOut.retrieveById(
                updateEmployeeModelCommand.getEmployeeId()
        ).map(
                employeeModel -> {

                    EmployeeModel.builder()
                            .employeeId(employeeModel.getEmployeeId())
                                    .name(updateEmployeeModelCommand.getName())
                                            .surname(updateEmployeeModelCommand.getSurname())
                                                    .email(updateEmployeeModelCommand.getEmail())
                            .build();

                    return updateEmployeeModelPortOut.persist(employeeModel);
                }
        ).get();
    }

    /* Update Employee with new Department */
    @Override
    public EmployeeModel updateDepartmentEmployeeModel(UpdateDepartmentEmployeeModelCommand updateDepartmentEmployeeModelCommand) {
        log.info("### Retrieving Employee ###");

        return this.getEmployeeModelPortOut.retrieveById(
                updateDepartmentEmployeeModelCommand.getEmployeeId()
        ).map(
                employeeModel -> {

                    employeeModel.setDepartmentModel(
                            getDepartmentModelPortOut.retrieveById(
                                    updateDepartmentEmployeeModelCommand.getDepartmentId()
                            ).orElseThrow(
                                    () -> new ObjectNotFound("### DepartmentModel not found ###")
                            )
                    );

                    return this.updateEmployeeModelPortOut.persist(employeeModel);
                }
        ).get();


    }

    /* Update Employee with new Project in Project List */
    @Override
    public EmployeeModel updateProjectListEmployeeModel(UpdateProjectListEmployeeModelCommand updateProjectListEmployeeModelCommand) {
        log.info("### Retrieving EmployeeModel ###");

        return this.getEmployeeModelPortOut.retrieveById(
                updateProjectListEmployeeModelCommand.getEmployeeId()
        ).map(employeeModel ->
            {
                Set<ProjectModel> projectModelSet = new HashSet<>(employeeModel.getProjectModelSet());

                projectModelSet.add(
                        this.getProjectModelPortOut.retrieveById(
                                updateProjectListEmployeeModelCommand.getProjectId()
                        ).orElseThrow(
                                () -> new ObjectNotFound("### ProjectModel Not Found ###")
                        )
                );

                employeeModel.setProjectModelSet(
                        projectModelSet
                );

                return this.updateEmployeeModelPortOut.persist(employeeModel);
            }
        ).get();

    }
}
