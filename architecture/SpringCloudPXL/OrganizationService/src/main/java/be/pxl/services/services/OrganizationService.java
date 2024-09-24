package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganizationById(long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization getOrganizationByIdWithDepartments(long Id) {
        return organizationRepository.findById(Id).orElse(null);
    }

    @Override
    public Organization getOrganizationByIdWithDepartmentsAndEmployees(long Id) {
        return organizationRepository.findById(Id).orElse(null);
    }

    @Override
    public Organization getOrganizationByIdWithEmployees(long Id) {
        return organizationRepository.findById(Id).orElse(null);
    }
}
