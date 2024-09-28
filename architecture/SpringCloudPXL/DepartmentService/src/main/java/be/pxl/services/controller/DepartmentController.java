package be.pxl.services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.services.IDepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    
    private IDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Void> addDepartment(@RequestBody @Valid DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable("id") Long id) {
        DepartmentResponse departmentResponse = departmentService.getDepartmentById(id);
        return departmentResponse != null ? 
                new ResponseEntity<>(departmentResponse, HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping(path = "/organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponse>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
       return new ResponseEntity<>(departmentService.findByOrganization(organizationId), HttpStatus.OK);
    }

    @GetMapping(path = "/organization/{organizationId}/with-employee")
    public ResponseEntity<List<DepartmentResponse>> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        return new ResponseEntity<>(departmentService.findByOrganizationWithEmployees(organizationId), HttpStatus.OK);
    }
}
