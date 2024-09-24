package be.pxl.services.services;

import be.pxl.services.domain.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartments();
    public Department getDepartmentById(long id);
    public Department addDepartment(Department department);
    public Department getByOrganizationId(long organizationId);
    public Department getByOrganizationIdWithEmployees(long organizationId);
}
