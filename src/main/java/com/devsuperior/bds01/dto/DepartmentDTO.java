package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDTO {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
