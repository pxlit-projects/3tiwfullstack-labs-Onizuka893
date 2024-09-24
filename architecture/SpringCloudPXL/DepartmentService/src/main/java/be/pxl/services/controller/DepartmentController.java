package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.addDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<Department>> findByOrganization(@PathVariable Long organizationId) {
        return null;
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<Department>>  findByOrganizationWithEmployees(@PathVariable Long organizationId, @PathVariable Long id) {
        return null;
    }
}
