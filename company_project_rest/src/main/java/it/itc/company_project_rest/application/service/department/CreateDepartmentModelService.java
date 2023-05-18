package it.itc.company_project_rest.application.service.department;

import it.itc.company_project_rest.application.command.department.CreateDepartmentModelCommand;
import it.itc.company_project_rest.application.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.application.port.in.department.CreateDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.out.department.CreateDepartmentModelPortOut;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*

 */


@Service
@Slf4j
@RequiredArgsConstructor
public class CreateDepartmentModelService implements CreateDepartmentModelUseCase {

    private final CreateDepartmentModelPortOut createDepartmentModelPortOut;
    private DepartmentMapper departmentMapper = new DepartmentMapper();

    @Override
    public DepartmentModel createDepartmentModel(CreateDepartmentModelCommand createDepartmentModelCommand) {
        log.info("#### Creating new DepartmentModel");
        DepartmentModel departmentModel =
                this.departmentMapper.fromCommandToModel(createDepartmentModelCommand);
        log.debug("#### DepartmentModel Created {} ####", departmentModel);
        return createDepartmentModelPortOut.persist(departmentModel);
    }
}
