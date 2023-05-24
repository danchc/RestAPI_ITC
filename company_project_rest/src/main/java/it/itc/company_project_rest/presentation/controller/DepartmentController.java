package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.department.DeleteDepartmentModelCommand;
import it.itc.company_project_rest.application.command.department.GetAllDepartmentsModelCommand;
import it.itc.company_project_rest.application.command.department.GetDepartmentModelCommand;
import it.itc.company_project_rest.application.port.in.department.CreateDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.in.department.DeleteDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.in.department.GetAllDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.in.department.GetDepartmentModelUseCase;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.presentation.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.presentation.request.department.DepartmentRequest;
import it.itc.company_project_rest.presentation.response.department.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/*

    Controller class for Department

 */

@RestController
@RequestMapping("/departments")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    /* casi d'uso */
    private final CreateDepartmentModelUseCase createDepartmentModelUseCase;
    private final GetDepartmentModelUseCase getDepartmentModelUseCase;
    private final DeleteDepartmentModelUseCase deleteDepartmentModelUseCase;
    private final GetAllDepartmentModelUseCase getAllDepartmentModelUseCase;

    private DepartmentMapper departmentMapper = new DepartmentMapper();


    /*
        API Create new Department
     */
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartmentModel(@RequestBody DepartmentRequest departmentRequest) {
        log.info("#### Creating new Department ####");
        log.debug("#### Requested to create {} ####", departmentRequest);

        return new ResponseEntity<DepartmentResponse>(
                departmentMapper.fromModelToResponse(createDepartmentModelUseCase.createDepartmentModel(
                        departmentMapper.fromRequestToCommand(departmentRequest)
                )),
                HttpStatus.CREATED);
    }


    /*
        API Retrieve Department by ID
     */
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponse> getDepartmentModel(@PathVariable UUID departmentId) {
        log.info("#### Retrieving Department ####");
        log.debug("#### Requested to retrieving {}",departmentId);

        /* create command */
        GetDepartmentModelCommand getDepartmentModelCommand =
                new GetDepartmentModelCommand(
                        new DepartmentId(departmentId)
                );

        Optional<DepartmentResponse> departmentResponse =
                getDepartmentModelUseCase.getDepartmentModel(getDepartmentModelCommand).map(departmentMapper::fromModelToResponse);

        if(departmentResponse.isPresent()){
            return ResponseEntity.ok(departmentResponse.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /*
        API Delete Department by ID
     */
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID departmentId){
        log.info("### Deleting Department ###");
        log.debug("### Requested to delete Department with ID {}", departmentId);

        this.deleteDepartmentModelUseCase.deleteDepartmentModel(
                new DeleteDepartmentModelCommand(
                        new DepartmentId(departmentId)
                )
        );

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    /*
        API RETRIEVE_ALL Department by ID
     */
    @GetMapping
    public ResponseEntity<Page<DepartmentResponse>> getAllDepartmentModels(
            @RequestParam(defaultValue = "100", required = false) int size,
            @RequestParam(defaultValue = "0", required = false) int page
    ) {
        log.info("### Retrieving all DepartmentModels ###");

        Page<DepartmentResponse> departmentResponses =
                this.getAllDepartmentModelUseCase.retrieveAllDepartments(
                        new GetAllDepartmentsModelCommand(
                                size,page
                        )
                ).map(this.departmentMapper::fromModelToResponse);

        return new ResponseEntity<>(departmentResponses, HttpStatus.OK);
    }
}
