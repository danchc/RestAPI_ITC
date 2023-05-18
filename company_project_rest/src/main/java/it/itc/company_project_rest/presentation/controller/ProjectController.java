package it.itc.company_project_rest.presentation.controller;

import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.presentation.request.project.ProjectRequest;
import it.itc.company_project_rest.presentation.response.project.ProjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*

    Controller class for Project

 */

@RestController
@RequestMapping("/project")
@Slf4j
@RequiredArgsConstructor
public class ProjectController {

    /* POST METHOD */
    public ResponseEntity<ProjectResponse> createProjectModel(@RequestBody ProjectRequest projectRequest) {
        log.info("#### Creating new Project ####");
        log.debug("#### Requested to create new Project {}", projectRequest);



    }



}
