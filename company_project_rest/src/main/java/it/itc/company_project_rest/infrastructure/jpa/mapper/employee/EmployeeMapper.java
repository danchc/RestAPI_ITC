package it.itc.company_project_rest.infrastructure.jpa.mapper.employee;

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.domain.model.employee.EmployeeId;
import it.itc.company_project_rest.domain.model.employee.EmployeeModel;
import it.itc.company_project_rest.domain.model.project.ProjectModel;
import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;
import it.itc.company_project_rest.infrastructure.entity.employee.EmployeeEntity;
import it.itc.company_project_rest.infrastructure.entity.employee_project.EmployeeProjectEntity;
import it.itc.company_project_rest.infrastructure.entity.project.ProjectEntity;
import it.itc.company_project_rest.infrastructure.jpa.mapper.department.DepartmentMapper;
import it.itc.company_project_rest.infrastructure.jpa.mapper.project.ProjectMapper;

import java.util.*;
import java.util.stream.Collectors;

/*

    Mapping Class for Employee

 */

public class EmployeeMapper {

    private final DepartmentMapper departmentMapper = new DepartmentMapper();
    private final ProjectMapper projectMapper = new ProjectMapper();


    /* fromModelToEntity */
    public EmployeeEntity fromModelToEntity(EmployeeModel employeeModel){
        DepartmentEntity departmentEntity = null;
        Set<EmployeeProjectEntity> employeeProjectEntities = new HashSet<>();

        if(employeeModel.getDepartmentModel() != null){
            departmentEntity = departmentMapper.fromModelToEntity(employeeModel.getDepartmentModel());
        }

        if(employeeModel.getProjectModelSet() != null){
           // projectEntitySet = employeeModel.getProjectModelSet().stream().map(projectMapper::fromModelToEntity).collect(Collectors.toSet());
            /*
                Prendo il Set<ProjectModel> e per ogni progetto al suo interno
                creo il corrispettivo EmployeeProjectEntity e creo Set<EmployeeProjectEntity>
             */

            employeeProjectEntities = employeeModel.getProjectModelSet().stream().map(
                    projectModel -> {
                        EmployeeEntity ee = EmployeeEntity.builder()
                                .employeeId(employeeModel.getEmployeeId().getEmployeeId())
                                .name(employeeModel.getName())
                                .surname(employeeModel.getSurname())
                                .email(employeeModel.getEmail())
                                .build();

                        return EmployeeProjectEntity.builder()
                                .employeeEntity(ee)
                                .projectEntity(ProjectEntity.builder()
                                        .projectId(this.projectMapper.fromModelToEntity(projectModel).getProjectId())
                                        .name(this.projectMapper.fromModelToEntity(projectModel).getName())
                                        .build())
                                .build();
                    }
            ).collect(Collectors.toSet());
        }

        return EmployeeEntity.builder()
                .employeeId(employeeModel.getEmployeeId().getEmployeeId())
                .email(employeeModel.getEmail())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .departmentEntity(departmentEntity)
                .projectEntitySet(employeeProjectEntities)
                .build();

    }

    /* fromEntityToModel */
    public EmployeeModel fromEntityToModel(EmployeeEntity employeeEntity){

        DepartmentModel departmentModel = null;
        Set<ProjectModel> projectModelSet = new HashSet<>();

        if(employeeEntity.getDepartmentEntity() != null) {
            departmentModel =
                    DepartmentModel.builder()
                            .departmentId(new DepartmentId(employeeEntity.getDepartmentEntity().getDepartmentId()))
                            .name(employeeEntity.getDepartmentEntity().getName())
                            .build();
        }

        if(employeeEntity.getProjectEntitySet() != null) {
            //projectModelSet = employeeEntity.getProjectEntitySet().stream().map(projectMapper::fromEntityToModel).collect(Collectors.toSet());
            projectModelSet = employeeEntity.getProjectEntitySet().stream().map(
                    employeeProjectEntity -> this.projectMapper.fromEntityToModel(employeeProjectEntity.getProjectEntity())
            ).collect(Collectors.toSet());
        }

        return EmployeeModel.builder()
                .employeeId(new EmployeeId(employeeEntity.getEmployeeId()))
                .email(employeeEntity.getEmail())
                .name(employeeEntity.getName())
                .surname(employeeEntity.getSurname())
                .departmentModel(departmentModel)
                .projectModelSet(projectModelSet)
                .build();
    }

}
