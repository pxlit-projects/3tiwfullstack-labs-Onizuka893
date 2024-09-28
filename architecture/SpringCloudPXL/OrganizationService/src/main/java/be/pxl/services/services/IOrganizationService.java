package be.pxl.services.services;

import be.pxl.services.domain.dto.OrganizationResponse;

import java.util.List;

public interface IOrganizationService {
    OrganizationResponse getOrganisationById(Long id);
    List<OrganizationResponse> findByIdWithDepartments (Long departmentId);
    List<OrganizationResponse> findByIdWithDepartmentsAndEmployees(Long departmentId);
    List<OrganizationResponse> findByIdWithEmployees(Long employeeId);

}
