package it.itc.company_project_rest.application.service.project;

import it.itc.company_project_rest.application.command.project.GetAllProjectModelCommand;
import it.itc.company_project_rest.application.port.in.project.GetAllProjectModelUseCase;
import it.itc.company_project_rest.application.port.out.project.GetAllProjectModelPortOut;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllProjectModelService implements GetAllProjectModelUseCase {

    private final GetAllProjectModelPortOut getAllProjectModelPortOut;

    @Override
    public Page<ProjectModel> getAllProjects(GetAllProjectModelCommand getAllProjectModelCommand) {
        return this.getAllProjectModelPortOut.findAll(
                PageRequest.of(
                        getAllProjectModelCommand.getPage(),
                        getAllProjectModelCommand.getSize()
                )
        );
    }
}
