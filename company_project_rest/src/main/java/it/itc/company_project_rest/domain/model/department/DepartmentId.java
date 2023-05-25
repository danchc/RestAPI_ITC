package it.itc.company_project_rest.domain.model.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
public class DepartmentId {

    private final UUID departmentId;

    public DepartmentId(UUID departmentId){
        this.departmentId = departmentId;
    }
}
