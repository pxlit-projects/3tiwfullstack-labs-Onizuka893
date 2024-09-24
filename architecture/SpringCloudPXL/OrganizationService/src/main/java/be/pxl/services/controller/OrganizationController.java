package be.pxl.services.controller;

import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<Organization> findById(@PathVariable long id) {
        return new ResponseEntity<Organization>(organizationService.getOrganizationById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity<Organization> findByIdWithDepartments(@PathVariable long id) {
        return new ResponseEntity<Organization>(organizationService.getOrganizationByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping("{id}/with-departments-and-employees")
    public ResponseEntity<Organization> findByIdWithDepartmentsAndEmployees(@PathVariable long id) {
        return new ResponseEntity<Organization>(organizationService.getOrganizationByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping("{id}/with-employees")
    public ResponseEntity<Organization> findByIdWithEmployees(@PathVariable long id) {
        return new ResponseEntity<Organization>(organizationService.getOrganizationByIdWithEmployees(id), HttpStatus.OK);
    }
}
