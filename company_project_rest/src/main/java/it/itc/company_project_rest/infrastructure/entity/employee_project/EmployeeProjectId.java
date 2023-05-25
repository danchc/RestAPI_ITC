package it.itc.company_project_rest.infrastructure.entity.employee_project;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectId implements Serializable {

    @Column(name = "employee_id")
    private UUID employeeId;

    @Column(name = "employee_id")
    private UUID projectId;

    /*
        Implementando Serializable è NECESSARIO fare Override dei metodi
        equals e hashCode
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EmployeeProjectId that = (EmployeeProjectId) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId);
    }

}
