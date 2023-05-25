package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.employee.*;
import it.itc.company_project_rest.application.port.in.employee.*;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.presentation.mapper.employee.EmployeeMapper;
import it.itc.company_project_rest.presentation.request.employee.EmployeeDepartmentRequest;
import it.itc.company_project_rest.presentation.request.employee.EmployeeProjectRequest;
import it.itc.company_project_rest.presentation.request.employee.EmployeeRequest;
import it.itc.company_project_rest.presentation.response.employee.EmployeeResponse;
import it.itc.company_project_rest.presentation.response.employee.GetEmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final CreateEmployeeModelUseCase createEmployeeModelUseCase;
    private final GetEmployeeModelUseCase getEmployeeModelUseCase;
    private final UpdateEmployeeModelUseCase updateEmployeeModelUseCase;
    private final DeleteEmployeeModelUseCase deleteEmployeeModelUseCase;
    private final GetAllEmployeeModelUseCase getAllEmployeeModelUseCase;

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

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
    public ResponseEntity<GetEmployeeResponse> getEmployeeModel(@PathVariable UUID employeeId) {
        log.info("#### Retrieving EmployeeModel ####");
        log.debug("#### Requested to retrieve {} ####", employeeId);

        GetEmployeeModelCommand getEmployeeModelCommand =
                new GetEmployeeModelCommand(
                        new EmployeeId(employeeId)
                );

        Optional<GetEmployeeResponse> employeeResponse =
                this.getEmployeeModelUseCase.retrieveEmployee(
                        getEmployeeModelCommand
                ).map(employeeMapper::fromModelToGetResponse);

        if(employeeResponse.isPresent()){
            return ResponseEntity.ok(employeeResponse.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
        API Retrieve Employees
     */
    @GetMapping
    public ResponseEntity<Page<GetEmployeeResponse>> getAllEmployees(
            @RequestParam(defaultValue = "100", required = false) int size,
            @RequestParam(defaultValue = "0", required = false) int page) {
        log.info("### Retrieve all Employees ###");

        Page<GetEmployeeResponse> employeeResponsePage =
                this.getAllEmployeeModelUseCase.getAllEmployeeModel(
                        new GetAllEmployeeModelCommand(
                                size,
                                page
                        )
                ).map(employeeMapper::fromModelToGetResponse);

        return new ResponseEntity<>(employeeResponsePage, HttpStatus.OK);
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
                HttpStatus.OK
        );

    }

    /*
        API Update Employee with new Department
     */
    @PutMapping("/dep/{employeeId}")
    public ResponseEntity<GetEmployeeResponse> updateDepartmentEmployeeModel(@PathVariable UUID employeeId, @RequestBody EmployeeDepartmentRequest employeeDepartmentRequest) {
        log.info("#### Updating EmployeeModel with Department####");
        log.debug("#### Requested to update {} with departmentId ####", employeeId);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToGetResponse(
                        this.updateEmployeeModelUseCase.updateDepartmentEmployeeModel(
                                new UpdateDepartmentEmployeeModelCommand(
                                        new EmployeeId(employeeId),
                                        new DepartmentId(employeeDepartmentRequest.getDepartmentId())
                                )
                        )
                ),
                HttpStatus.OK
        );
    }

    /*
        API Update Employee with new Project
     */
    @PutMapping("/project/{employeeId}")
    public ResponseEntity<GetEmployeeResponse> updateProjectListEmployeeModel(@PathVariable UUID employeeId, @RequestBody EmployeeProjectRequest employeeProjectRequest){
        log.info("#### Updating EmployeeModel with Project####");
        log.debug("#### Requested to update {} with departmentId ####", employeeId);

        return new ResponseEntity<>(
                this.employeeMapper.fromModelToGetResponse(
                        this.updateEmployeeModelUseCase.updateProjectListEmployeeModel(
                                new UpdateProjectListEmployeeModelCommand(
                                        new EmployeeId(employeeId),
                                        new ProjectId(employeeProjectRequest.getProjectId())
                                )
                        )
                ),
                HttpStatus.OK
        );

    }

    /*
        API Delete Employee
     */
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeModel(@PathVariable UUID employeeId){
        log.info("### Deleting Employee ###");
        log.debug("### Requested delete Employee with ID {} ###", employeeId);

        this.deleteEmployeeModelUseCase.deleteEmployeeModel(
                new DeleteEmployeeModelCommand(
                        new EmployeeId(employeeId)
                )
        );

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}
