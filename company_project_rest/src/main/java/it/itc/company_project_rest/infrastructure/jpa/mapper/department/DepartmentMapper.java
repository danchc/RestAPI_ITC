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
        return new DepartmentEntity(
                departmentModel.getDepartmentId().getDepartmentId(),
                departmentModel.getName()
        );
    }

    /* fromEntityToModel */
    public DepartmentModel fromModelToEntity(DepartmentEntity departmentEntity) {
        return new DepartmentModel(
                new DepartmentId(departmentEntity.getDepartmentId()),
                departmentEntity.getName()
        );
    }
}
