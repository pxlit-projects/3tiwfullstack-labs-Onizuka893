package be.pxl.services.domain.dto;

import java.util.List;

import be.pxl.services.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private Long organizationId;
    private String name;
    private List<Employee> employees;
    private String position;
}
