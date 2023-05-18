package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.application.command.department.GetDepartmentModelCommand;
import it.itc.company_project_rest.application.port.in.department.CreateDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.in.department.GetDepartmentModelUseCase;
import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.presentation.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.presentation.request.department.DepartmentRequest;
import it.itc.company_project_rest.presentation.response.department.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/*

    Controller class for Department

 */

@RestController
@RequestMapping("/department")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    /* casi d'uso */
    private final CreateDepartmentModelUseCase createDepartmentModelUseCase;
    private final GetDepartmentModelUseCase getDepartmentModelUseCase;

    private DepartmentMapper departmentMapper = new DepartmentMapper();


    /* POST METHOD */
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


    /* GET METHOD */
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

    /* DELETE METHOD */

    /* PUT METHOD */


}
