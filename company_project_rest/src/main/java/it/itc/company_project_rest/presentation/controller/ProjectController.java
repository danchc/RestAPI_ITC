package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.application.command.project.GetProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.CreateProjectModelUseCase;

import it.itc.company_project_rest.application.port.in.project.GetProjectModelUseCase;
import it.itc.company_project_rest.domain.model.project.ProjectId;
import it.itc.company_project_rest.presentation.mapper.project.ProjectMapper;
import it.itc.company_project_rest.presentation.request.project.ProjectRequest;
import it.itc.company_project_rest.presentation.response.project.ProjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/project")
public class ProjectController {

    private final CreateProjectModelUseCase createProjectModelUseCase;
    private final GetProjectModelUseCase getProjectModelUseCase;

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



}
