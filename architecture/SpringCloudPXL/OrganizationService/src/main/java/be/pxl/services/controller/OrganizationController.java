package be.pxl.services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping(path = "/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;
    
     @GetMapping(path = "/{id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(@PathVariable("id") Long id) {
        OrganizationResponse organizationResponse = organizationService.getOrganisationById(id);
        return organizationResponse != null ? 
                new ResponseEntity<>(organizationResponse, HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{organizationId}/with-departments")
    public ResponseEntity<List<OrganizationResponse>> findByIdWithDepartments(@PathVariable("organizationId") Long organizationId) {
       return new ResponseEntity<>(organizationService.findByIdWithDepartments(organizationId), HttpStatus.OK);
    }

    @GetMapping(path = "/{organizationId}/with-departments-and-employees")
    public ResponseEntity<List<OrganizationResponse>> findByIdWithDepartmentsAndEmployees(@PathVariable("organizationId") Long organizationId) {
        return new ResponseEntity<>(organizationService.findByIdWithDepartmentsAndEmployees(organizationId), HttpStatus.OK);
    }

    @GetMapping(path = "/{organizationId}/with-employees")
    public ResponseEntity<List<OrganizationResponse>> findByIdWithEmployees(@PathVariable("organizationId") Long organizationId) {
        return new ResponseEntity<>(organizationService.findByIdWithEmployees(organizationId), HttpStatus.OK);
    }
}
