package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(employeeService.findAllPaged(pageable));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insertEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO = employeeService.insertEmployee(employeeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(employeeDTO);
    }
}
