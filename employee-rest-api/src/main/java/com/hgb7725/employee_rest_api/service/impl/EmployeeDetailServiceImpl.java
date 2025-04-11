package com.hgb7725.employee_rest_api.service.impl;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.EmployeeDetail;
import com.hgb7725.employee_rest_api.exception.ApiException;
import com.hgb7725.employee_rest_api.repository.EmployeeDetailRepository;
import com.hgb7725.employee_rest_api.repository.EmployeeRepository;
import com.hgb7725.employee_rest_api.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {

    private EmployeeDetailRepository employeeDetailRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDetailServiceImpl(EmployeeDetailRepository employeeDetailRepository,
                                      EmployeeRepository employeeRepository) {
        this.employeeDetailRepository = employeeDetailRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDetail getEmployeeDetailByEmployeeId(Integer id) {
        EmployeeDetail employeeDetail = employeeDetailRepository.findByEmployeeId(id);
        if (employeeDetail == null) {
            throw new ApiException("Employee detail not found for employee ID: " + id, HttpStatus.NOT_FOUND);
        }
        return employeeDetail;
    }

    @Override
    public List<EmployeeDetail> getAllEmployeeDetails() {
        return employeeDetailRepository.findAll();
    }

    @Override
    public EmployeeDetail getEmployeeDetailById(Integer id) {
        return employeeDetailRepository.findById(id).orElseThrow(
                () -> new ApiException("Employee detail not found for ID: " + id, HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public EmployeeDetail saveEmployeeDetail(EmployeeDetail employeeDetail) {
        return employeeDetailRepository.save(employeeDetail);
    }

    @Override
    public EmployeeDetail deleteEmployeeDetailById(Integer id) {
        EmployeeDetail employeeDetail = employeeDetailRepository.findById(id).orElseThrow(
                () -> new ApiException("Employee detail not found for ID: " + id, HttpStatus.NOT_FOUND)
        );
        Employee employee = employeeDetail.getEmployee();
        if (employee != null) {
            employee.setEmployeeDetail(null);
            employeeRepository.save(employee);
        }
        employeeDetailRepository.deleteById(id);
        return employeeDetail;
    }
}
