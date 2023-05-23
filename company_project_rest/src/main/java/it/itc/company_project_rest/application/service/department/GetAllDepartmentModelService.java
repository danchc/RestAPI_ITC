package it.itc.company_project_rest.application.service.department;

import it.itc.company_project_rest.application.command.department.GetAllDepartmentsModelCommand;
import it.itc.company_project_rest.application.port.in.department.GetAllDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.out.department.GetAllDepartmentModelPortOut;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllDepartmentModelService implements GetAllDepartmentModelUseCase {

    private final GetAllDepartmentModelPortOut getAllDepartmentModelPortOut;

    @Override
    public Page<DepartmentModel> retrieveAllDepartments(GetAllDepartmentsModelCommand getAllDepartmentsModelCommand) {
        return getAllDepartmentModelPortOut.findAll(
                PageRequest.of(
                        getAllDepartmentsModelCommand.getPage(),
                        getAllDepartmentsModelCommand.getSize()
                )
        );
    }
}
