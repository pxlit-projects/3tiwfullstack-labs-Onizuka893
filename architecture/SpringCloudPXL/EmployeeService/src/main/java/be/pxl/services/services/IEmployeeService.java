package be.pxl.services.services;

import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    public Employee getEmployeeById(long id);
    public List<Employee> getByOrganizationId(long organizationId);
    public List<Employee> getByDepartmentId(long departmentId);
}
