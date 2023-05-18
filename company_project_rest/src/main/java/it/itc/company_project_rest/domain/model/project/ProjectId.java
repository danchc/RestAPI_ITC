package it.itc.company_project_rest.domain.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProjectId {

    private final UUID projectId;

}
