package it.itc.company_project_rest.domain.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
public class ProjectId {

    private final UUID projectId;

    public ProjectId(UUID projectId){
        this.projectId = projectId;
    }

}
