package it.itc.company_project_rest.infrastructure.jpa.mapper.department;

/*

    Mapping class for Department

 */

import it.itc.company_project_rest.domain.model.department.DepartmentId;
import it.itc.company_project_rest.domain.model.department.DepartmentModel;
import it.itc.company_project_rest.infrastructure.entity.department.DepartmentEntity;

public class DepartmentMapper {

    /* fromModelToEntity */
    public DepartmentEntity fromModelToEntity(DepartmentModel departmentModel) {

        return DepartmentEntity.builder()
                .departmentId(departmentModel.getDepartmentId().getDepartmentId())
                .name(departmentModel.getName())
                .build();

    }

    /* fromEntityToModel */
    public DepartmentModel fromEntityToModel(DepartmentEntity departmentEntity) {
        return DepartmentModel.builder()
                .departmentId(new DepartmentId(departmentEntity.getDepartmentId()))
                .name(departmentEntity.getName())
                .build();
    }
}