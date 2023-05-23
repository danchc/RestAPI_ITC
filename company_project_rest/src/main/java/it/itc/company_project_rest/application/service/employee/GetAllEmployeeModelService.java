package it.itc.company_project_rest.application.service.employee;

import it.itc.company_project_rest.application.command.employee.GetAllEmployeeModelCommand;
import it.itc.company_project_rest.application.port.in.employee.GetAllEmployeeModelUseCase;
import it.itc.company_project_rest.application.port.out.employee.GetAllEmployeeModelPortOut;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllEmployeeModelService implements GetAllEmployeeModelUseCase {

    private final GetAllEmployeeModelPortOut getAllEmployeeModelPortOut;

    @Override
    public Page<EmployeeModel> getAllEmployeeModel(GetAllEmployeeModelCommand getAllEmployeeModelCommand) {
        return getAllEmployeeModelPortOut.findAll(
                PageRequest.of(
                        getAllEmployeeModelCommand.getPage(),
                        getAllEmployeeModelCommand.getSize()
                )
        );
    }
}
