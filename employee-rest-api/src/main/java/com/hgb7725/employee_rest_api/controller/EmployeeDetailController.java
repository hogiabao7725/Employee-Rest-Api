package com.hgb7725.employee_rest_api.controller;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.EmployeeDetail;
import com.hgb7725.employee_rest_api.service.EmployeeDetailService;
import com.hgb7725.employee_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeDetailController {

    private EmployeeDetailService employeeDetailService;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeDetailController(EmployeeDetailService employeeDetailService, EmployeeService employeeService) {
        this.employeeDetailService = employeeDetailService;
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}/detail")
    public ResponseEntity<EmployeeDetail> getEmployeeDetail(@PathVariable("id") Integer employeeId) {
        return ResponseEntity.ok(employeeDetailService.getEmployeeDetailByEmployeeId(employeeId));
    }

    @GetMapping("/employee-details")
    public ResponseEntity<List<EmployeeDetail>> getAllEmployeeDetails() {
        List<EmployeeDetail> employeeDetails = employeeDetailService.getAllEmployeeDetails();
        if (employeeDetails.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(employeeDetails);
        }
    }

    @GetMapping("/employee-details/{id}")
    public ResponseEntity<EmployeeDetail> getEmployeeDetailById(@PathVariable("id") Integer id) {
        EmployeeDetail employeeDetail = employeeDetailService.getEmployeeDetailById(id);
        return ResponseEntity.ok(employeeDetail);
    }

    @PostMapping("/employee-details")
    @Transactional
    public ResponseEntity<EmployeeDetail> createEmployeeDetail(@RequestBody EmployeeDetail employeeDetail) {
        employeeDetail.setId(null);
        EmployeeDetail savedEmployeeDetail = employeeDetailService.saveEmployeeDetail(employeeDetail);
        return ResponseEntity.status(201).body(savedEmployeeDetail);
    }

    @PutMapping("/employee-details/{id}")
    @Transactional
    public ResponseEntity<EmployeeDetail> updateEmployeeDetail(@PathVariable("id") Integer id, @RequestBody EmployeeDetail employeeDetail) {
        employeeDetail.setId(id);
        return ResponseEntity.ok(employeeDetailService.saveEmployeeDetail(employeeDetail));
    }

    @DeleteMapping("/employee-details/{id}")
    @Transactional
    public ResponseEntity<EmployeeDetail> deleteEmployeeDetail(@PathVariable("id") Integer id) {
        EmployeeDetail employeeDetail = employeeDetailService.deleteEmployeeDetailById(id);
        return ResponseEntity.ok(employeeDetail);
    }

}
