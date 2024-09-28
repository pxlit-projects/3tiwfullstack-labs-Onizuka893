package be.pxl.services.services;

import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(Long id);
    void addEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> findByDepartment(Long departmentId);
    List<EmployeeResponse> findByOrganization(Long organizationId);
}
