package be.pxl.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse getOrganisationById(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        return mapToOrganizationResponseWithDepartmentsAndEmployees(organization);
    }

    @Override
    public List<OrganizationResponse> findByIdWithDepartments(Long departmentId) {
        List<Organization> organization = organizationRepository.findAll();
        return organization.stream()
                .map(this::mapToOrganizationResponseWithDepartments)
                .toList();
    }

    @Override
    public List<OrganizationResponse> findByIdWithDepartmentsAndEmployees(Long departmentId) {
        List<Organization> organization = organizationRepository.findAll();
        return organization.stream()
                .map(this::mapToOrganizationResponseWithDepartments)
                .toList();
    }

    @Override
    public List<OrganizationResponse> findByIdWithEmployees(Long employeeId) {
        List<Organization> organization = organizationRepository.findAll();
        return organization.stream()
                .map(this::mapToOrganizationResponseWithDepartments)
                .toList();
    }

    private OrganizationResponse mapToOrganizationResponseWithDepartments(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(new ArrayList<Department>())
                .build();
    }

    private OrganizationResponse mapToOrganizationResponseWithEmployees(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(new ArrayList<Employee>())
                .build();
    }

    private OrganizationResponse mapToOrganizationResponseWithDepartmentsAndEmployees(Organization organization) {

        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(new ArrayList<Department>())
                .employees(new ArrayList<Employee>())
                .build();
    }
}
