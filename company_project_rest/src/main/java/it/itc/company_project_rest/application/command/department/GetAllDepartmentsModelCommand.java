package it.itc.company_project_rest.application.command.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class GetAllDepartmentsModelCommand {

    private final int size;
    private final int page;
}
