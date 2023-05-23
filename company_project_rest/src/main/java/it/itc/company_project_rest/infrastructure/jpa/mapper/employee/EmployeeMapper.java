package it.itc.company_project_rest.infrastructure.jpa.mapper.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.jpa.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.infrastructure.jpa.mapper.project.ProjectMapper;
import java.util.LinkedList;

/*

    Mapping Class for Employee

 */

public class EmployeeMapper {

    private DepartmentMapper departmentMapper = new DepartmentMapper();
    private ProjectMapper projectMapper = new ProjectMapper();

    /* fromModelToEntity */
    public EmployeeEntity fromModelToEntity(EmployeeModel employeeModel){
        return EmployeeEntity.builder()
                .employeeId(employeeModel.getEmployeeId().getEmployeeId())
                .email(employeeModel.getEmail())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                /* da rivedere
                .departmentEntity(
                        departmentMapper.fromModelToEntity(employeeModel.getDepartmentModel())
                )
                .projectEntityList(
                        employeeModel.getProjectModelList().stream().map(projectMapper::fromModelToEntity).toList()
                )*/.build();

    }

    /* fromEntityToModel */
    public EmployeeModel fromEntityToModel(EmployeeEntity employeeEntity){
        return EmployeeModel.builder()
                .employeeId(new EmployeeId(employeeEntity.getEmployeeId()))
                .email(employeeEntity.getEmail())
                .name(employeeEntity.getName())
                .surname(employeeEntity.getSurname())
                /*
                .departmentModel(
                        new DepartmentModel(
                                new DepartmentId(employeeEntity.getDepartmentEntity().getDepartmentId()),
                                employeeEntity.getDepartmentEntity().getName()
                            )
                        )
                .projectModelList(
                        new LinkedList<>(
                                employeeEntity.getProjectEntityList().stream().map(projectMapper::fromEntityToModel).toList()
                        )
                )*/
                .build();
    }

}
