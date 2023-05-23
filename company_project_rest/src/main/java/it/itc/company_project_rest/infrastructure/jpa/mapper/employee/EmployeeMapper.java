package it.itc.company_project_rest.infrastructure.jpa.mapper.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import it.itc.company_project_rest.infrastructure.jpa.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.infrastructure.jpa.mapper.project.ProjectMapper;
import java.util.LinkedList;
import java.util.List;

/*

    Mapping Class for Employee

 */

public class EmployeeMapper {

    private DepartmentMapper departmentMapper = new DepartmentMapper();
    private ProjectMapper projectMapper = new ProjectMapper();

    /* fromModelToEntity */
    public EmployeeEntity fromModelToEntity(EmployeeModel employeeModel){
        DepartmentEntity departmentEntity = null;
        List<ProjectEntity> projectEntityList = new LinkedList<>();

        if(employeeModel.getDepartmentModel() != null){
             departmentEntity = departmentMapper.fromModelToEntity(employeeModel.getDepartmentModel());
        }

        if(employeeModel.getProjectModelList() != null){
            projectEntityList = employeeModel.getProjectModelList().stream().map(projectMapper::fromModelToEntity).toList();
        }

        return EmployeeEntity.builder()
                .employeeId(employeeModel.getEmployeeId().getEmployeeId())
                .email(employeeModel.getEmail())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                /* da rivedere */
                .departmentEntity(
                        departmentEntity
                )
                .projectEntityList(
                        projectEntityList
                ).build();

    }

    /* fromEntityToModel */
    public EmployeeModel fromEntityToModel(EmployeeEntity employeeEntity){

        DepartmentModel departmentModel = null;
        List<ProjectModel> projectModelList = new LinkedList<>();

        if(employeeEntity.getDepartmentEntity() != null) {
            departmentModel = new DepartmentModel(
                    new DepartmentId(
                            employeeEntity.getDepartmentEntity().getDepartmentId()
                    ),
                    employeeEntity.getName()
            );
        }

        if(employeeEntity.getProjectEntityList() != null) {
            projectModelList = employeeEntity.getProjectEntityList().stream().map(projectMapper::fromEntityToModel).toList();
        }

        return EmployeeModel.builder()
                .employeeId(new EmployeeId(employeeEntity.getEmployeeId()))
                .email(employeeEntity.getEmail())
                .name(employeeEntity.getName())
                .surname(employeeEntity.getSurname())
                .departmentModel(
                        departmentModel
                )
                .projectModelList(
                        projectModelList
                )
                .build();
    }

}