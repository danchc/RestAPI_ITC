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

import java.util.LinkedList;
import java.util.List;

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
                    employeeModel.setName(updateEmployeeModelCommand.getName());
                    employeeModel.setSurname(updateEmployeeModelCommand.getSurname());
                    employeeModel.setEmail(updateEmployeeModelCommand.getEmail());
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
                List<ProjectModel> projectModelList = new LinkedList<>(employeeModel.getProjectModelList());

                projectModelList.add(
                        this.getProjectModelPortOut.retrieveById(
                                updateProjectListEmployeeModelCommand.getProjectId()
                        ).orElseThrow(
                                () -> new ObjectNotFound("### ProjectModel Not Found ###")
                        )
                );

                employeeModel.setProjectModelList(
                        projectModelList
                );

                return this.updateEmployeeModelPortOut.persist(employeeModel);
            }
        ).get();

    }
}
