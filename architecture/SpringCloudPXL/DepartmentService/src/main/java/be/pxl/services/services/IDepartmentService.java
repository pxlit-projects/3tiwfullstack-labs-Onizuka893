package be.pxl.services.services;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> getAllDepartments();
    DepartmentResponse getDepartmentById(Long id);
    void addDepartment(DepartmentRequest departmentRequest);
    List<DepartmentResponse> findByOrganization(Long organizationId);
    List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId);
}
