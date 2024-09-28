package be.pxl.services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }

    public EmployeeResponse mapToEmployeeResponse(Employee employees) {
       return EmployeeResponse.builder()
                .organizationId(employees.getOrganizationId())
                .departmentId(employees.getDepartmentId())
                .name(employees.getName())
                .age(employees.getAge())
                .position(employees.getPosition())
                .build();
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(this::mapToEmployeeResponse)
                .orElse(null);
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
       Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .departmentId(employeeRequest.getDepartmentId())
                .organizationId(employeeRequest.getOrganizationId())
                .age(employeeRequest.getAge())
                .position(employeeRequest.getPosition())
                .build();
        employeeRepository.save(employee);  
    }

    @Override
    public List<EmployeeResponse> findByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId).stream().map(this::mapToEmployeeResponse).toList();
    }

    @Override
    public List<EmployeeResponse> findByOrganization(Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId).stream().map(this::mapToEmployeeResponse).toList();
    }

}
