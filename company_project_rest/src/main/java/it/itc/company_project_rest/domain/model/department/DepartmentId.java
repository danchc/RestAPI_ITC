package it.itc.company_project_rest.domain.model.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
/* no argomenti perchè sennò HttpConversionException !!! */
public class DepartmentId {

    private UUID departmentId;
}
