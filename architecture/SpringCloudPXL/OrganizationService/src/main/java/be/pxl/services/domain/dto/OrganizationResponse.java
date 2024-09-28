package be.pxl.services.domain.dto;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {
    private String name;
    private String address;
    @ManyToAny
    private List<Employee> employees;
    @ManyToAny
    private List<Department> departments;
}
