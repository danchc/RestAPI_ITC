package it.itc.company_project_rest.application.service.department;

import it.itc.company_project_rest.application.command.department.DeleteDepartmentModelCommand;
import it.itc.company_project_rest.application.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.application.port.in.department.DeleteDepartmentModelUseCase;
import it.itc.company_project_rest.application.port.out.department.DeleteDepartmentModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteDepartmentModelService implements DeleteDepartmentModelUseCase {

    private final DeleteDepartmentModelPortOut deleteDepartmentModelPortOut;

    private DepartmentMapper departmentMapper = new DepartmentMapper();

    @Override
    public void deleteDepartmentModel(DeleteDepartmentModelCommand deleteDepartmentModelCommand) {
        log.info("### Deleting Department Model ###");
        this.deleteDepartmentModelPortOut.deleteById(
                deleteDepartmentModelCommand.getDepartmentId()
        );
    }
}
