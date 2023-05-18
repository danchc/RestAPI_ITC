package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.application.port.in.department.CreateDepartmentModelUseCase;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.presentation.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.presentation.request.department.DepartmentRequest;
import it.itc.company_project_rest.presentation.response.department.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /* DELETE METHOD */

    /* PUT METHOD */


}
