package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.employee.GetEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateDepartmentEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateEmployeeModelCommand;
import it.itc.company_project_rest.application.command.employee.UpdateProjectListEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.CreateEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.in.employee.GetEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.in.employee.UpdateEmployeeModelUseCase;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.presentation.mapper.employee.EmployeeMapper;
import it.itc.company_project_rest.presentation.request.employee.EmployeeDepartmentRequest;
import it.itc.company_project_rest.presentation.request.employee.EmployeeProjectRequest;
import it.itc.company_project_rest.presentation.request.employee.EmployeeRequest;
import it.itc.company_project_rest.presentation.response.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final CreateEmployeeModelUseCase createEmployeeModelUseCase;
    private final GetEmployeeModelUseCase getEmployeeModelUseCase;
    private final UpdateEmployeeModelUseCase updateEmployeeModelUseCase;

    private EmployeeMapper employeeMapper = new EmployeeMapper();

    /*
        API Create new Employee with common fields
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployeeModel(@RequestBody EmployeeRequest employeeRequest){
        log.info("#### Creating new EmployeeModel ####");
        log.debug("#### Requested to create {} ####", employeeRequest);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToResponse(
                        this.createEmployeeModelUseCase.createEmployeeModel(
                                this.employeeMapper.fromRequestToCommand(employeeRequest)
                        )
                ),
                HttpStatus.CREATED
        );
    }

    /*
        API Retrieve Employee with ID
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployeeModel(@PathVariable UUID employeeId) {
        log.info("#### Retrieving EmployeeModel ####");
        log.debug("#### Requested to retrieve {} ####", employeeId);

        GetEmployeeModelCommand getEmployeeModelCommand =
                new GetEmployeeModelCommand(
                        new EmployeeId(employeeId)
                );

        Optional<EmployeeResponse> employeeResponse =
                this.getEmployeeModelUseCase.retrieveEmployee(
                        getEmployeeModelCommand
                ).map(employeeMapper::fromModelToResponse);

        if(employeeResponse.isPresent()){
            return ResponseEntity.ok(employeeResponse.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
        API Update Employee with common fields
     */
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateEmployeeModel(@PathVariable UUID employeeId, @RequestBody EmployeeRequest employeeRequest) {
        log.info("#### Updating EmployeeModel ####");
        log.debug("#### Requested to update {} ####", employeeId);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToResponse(
                        this.updateEmployeeModelUseCase.updateEmployeeModel(
                                new UpdateEmployeeModelCommand(
                                        new EmployeeId(employeeId),
                                        employeeRequest.getName(),
                                        employeeRequest.getSurname(),
                                        employeeRequest.getEmail()
                                )
                        )
                ),
                HttpStatus.ACCEPTED
        );

    }

    /*
        API Update Employee with new Department
     */
    @PutMapping("/dep/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateDepartmentEmployeeModel(@PathVariable UUID employeeId, @RequestBody EmployeeDepartmentRequest employeeDepartmentRequest) {
        log.info("#### Updating EmployeeModel with Department####");
        log.debug("#### Requested to update {} with departmentId ####", employeeId);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToResponse(
                        this.updateEmployeeModelUseCase.updateDepartmentEmployeeModel(
                                new UpdateDepartmentEmployeeModelCommand(
                                        new EmployeeId(employeeId),
                                        employeeDepartmentRequest.getDepartmentId()
                                )
                        )
                ),
                HttpStatus.ACCEPTED
        );
    }

    /*
        API Update Employee with new Project
     */
    @PutMapping("/project/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateProjectListEmployeeModel(@PathVariable UUID employeeId, @RequestBody EmployeeProjectRequest employeeProjectRequest){
        log.info("#### Updating EmployeeModel with Project####");
        log.debug("#### Requested to update {} with departmentId ####", employeeId);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToResponse(
                        this.updateEmployeeModelUseCase.updateProjectListEmployeeModel(
                                new UpdateProjectListEmployeeModelCommand(
                                        new EmployeeId(employeeId),
                                        employeeProjectRequest.getProjectId()
                                )
                        )
                ),
                HttpStatus.ACCEPTED
        );

    }


}
