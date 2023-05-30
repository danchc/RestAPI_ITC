package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.department.GetAllDepartmentsModelCommand;
import it.itc.company_project_rest.application.command.project.*;
import it.itc.company_project_rest.application.port.in.project.*;

import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import it.itc.company_project_rest.presentation.mapper.project.ProjectMapper;
import it.itc.company_project_rest.presentation.request.project.ProjectEmployeeRequest;
import it.itc.company_project_rest.presentation.request.project.ProjectRequest;
import it.itc.company_project_rest.presentation.response.department.DepartmentResponse;
import it.itc.company_project_rest.presentation.response.project.ProjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/*

    Controller class for Project

 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final CreateProjectModelUseCase createProjectModelUseCase;
    private final GetProjectModelUseCase getProjectModelUseCase;
    private final DeleteProjectModelUseCase deleteProjectModelUseCase;
    private final GetAllProjectModelUseCase getAllProjectModelUseCase;
    private final UpdateProjectModelUseCase updateProjectModelUseCase;
    private final UpdateProjectModelEmployeeUseCase updateProjectModelEmployeeUseCase;

    private final ProjectMapper projectMapper = new ProjectMapper();

    /*
        API Create new Project
     */
    @PostMapping
    public ResponseEntity<ProjectResponse> createProjectModel(@RequestBody ProjectRequest projectRequest) {
        log.info("#### Creating new Project ####");
        log.debug("#### Requested to create new Project {}", projectRequest);

        return new ResponseEntity<ProjectResponse>(
                this.projectMapper.fromModelToResponse(
                        createProjectModelUseCase.createProjectModel(
                                this.projectMapper.fromRequestToCommand(projectRequest)
                        )
                ),
                HttpStatus.CREATED
        );
    }

    /*
        API Retrieve Project by ID
     */
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProjectModel(@PathVariable UUID projectId){
        log.info("#### Retrieving new Project ####");
        log.debug("#### Requested to retrieve new Project {}", projectId);

        GetProjectModelCommand getProjectModelCommand =
                new GetProjectModelCommand(
                        new ProjectId(projectId)
                );

        Optional<ProjectResponse> projectResponse =
                this.getProjectModelUseCase.retrieveProjectModel(
                        getProjectModelCommand
                ).map(projectMapper::fromModelToResponse);

        if(projectResponse.isPresent()) {
            return ResponseEntity.ok(projectResponse.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /*
        API Retrieve all Projects
     */
    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> getAllProjects(
            @RequestParam(defaultValue = "100", required = false) int size,
            @RequestParam(defaultValue = "0", required = false) int page
    ) {
        log.info("### Retrieve all Projects ###");

        Page<ProjectResponse> projectResponses =
                this.getAllProjectModelUseCase.getAllProjects(
                        new GetAllProjectModelCommand(
                                size,page
                        )
                ).map(this.projectMapper::fromModelToResponse);

        return new ResponseEntity<>(projectResponses, HttpStatus.OK);


    }


    /*
        API Delete Project by ID
     */
    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID projectId){
        log.info("### Deleting Project ###");
        log.debug("### Requested to delete Project with ID {} ###", projectId);

        this.deleteProjectModelUseCase.deleteProjectModel(
                new DeleteProjectModelCommand(
                        new ProjectId(projectId)
                )
        );

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /* API Update Project */
    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable UUID projectId, @RequestBody ProjectRequest projectRequest){
        log.info("### Updating Project ###");
        log.debug("### Requested to update Project {}", projectId);

        return new ResponseEntity<>(
                this.projectMapper.fromModelToResponse(
                        this.updateProjectModelUseCase.updateProjectModel(
                                new UpdateProjectModelCommand(
                                        new ProjectId(projectId),
                                        projectRequest.getName(),
                                        projectRequest.getStartDate(),
                                        projectRequest.getEndDate()
                                )
                        )
                ),
                HttpStatus.OK
        );
    }

    /* API Add Employee in Project */
    @PutMapping("/employee/{projectId}")
    public ResponseEntity<Void> addEmployee(@PathVariable UUID projectId, @RequestBody ProjectEmployeeRequest projectEmployeeRequest){
        log.info("### Adding new Employee in Project ###");
        log.debug("### Requested to update Project {} ###", projectId);

        this.updateProjectModelEmployeeUseCase.addEmployeeProject(
                new UpdateProjectModelEmployeeCommand(
                        new ProjectId(projectId),
                        new EmployeeId(projectEmployeeRequest.getEmployeeId())
                )
        );

        return new ResponseEntity<>(
                HttpStatus.ACCEPTED
        );
    }


}
