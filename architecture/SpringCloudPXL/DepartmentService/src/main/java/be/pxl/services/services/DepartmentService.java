package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        return departmentRepository.getReferenceById(id);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getByOrganizationId(long organizationId) {
        return null;
    }

    @Override
    public Department getByOrganizationIdWithEmployees(long organizationId) {
        return null;
    }
}
