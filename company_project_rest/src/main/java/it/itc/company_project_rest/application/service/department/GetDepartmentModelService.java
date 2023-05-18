package it.itc.company_project_rest.application.service.department;

import it.itc.company_project_rest.application.command.department.GetDepartmentModelCommand;
import it.itc.company_project_rest.application.port.in.department.GetDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.out.department.GetDepartmentModelPortOut;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class GetDepartmentModelService implements GetDepartmentModelUseCase {

    private final GetDepartmentModelPortOut getDepartmentModelPortOut;


    @Override
    public Optional<DepartmentModel> getDepartmentModel(GetDepartmentModelCommand getDepartmentModelCommand) {
        log.info("#### Retrieving DepartmentModel ####");
        return this.getDepartmentModelPortOut.retrieveById(
                getDepartmentModelCommand.getDepartmentId()
        );
    }
}
