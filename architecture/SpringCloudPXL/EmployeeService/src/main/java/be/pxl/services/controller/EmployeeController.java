package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public Employee add(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable Long departmentId) {
        return null;
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<Employee>> findByOrganization(@PathVariable Long organizationId) {
        return null;
    }
}
