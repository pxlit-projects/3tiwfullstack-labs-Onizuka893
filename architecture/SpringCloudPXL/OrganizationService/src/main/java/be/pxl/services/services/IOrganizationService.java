package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {
    public Organization getOrganizationById(long id);
    public Organization getOrganizationByIdWithDepartments(long Id);
    public Organization getOrganizationByIdWithDepartmentsAndEmployees(long Id);
    public Organization getOrganizationByIdWithEmployees(long Id);

}
