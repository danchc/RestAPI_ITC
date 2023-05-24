package it.itc.company_project_rest.application.command.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllProjectModelCommand {

    private final int size;
    private final int page;
}
