package be.pxl.services.domain;

import jakarta.persistence.Transient;

import java.util.List;

public class Department {
    private Long id;

    private long organizationId;
    private String name;

    private List<Employee> employees;
    private String position;
}
