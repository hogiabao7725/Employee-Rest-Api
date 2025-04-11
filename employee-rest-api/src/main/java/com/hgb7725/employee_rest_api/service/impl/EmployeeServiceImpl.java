package com.hgb7725.employee_rest_api.service.impl;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.Manager;
import com.hgb7725.employee_rest_api.exception.ApiException;
import com.hgb7725.employee_rest_api.repository.EmployeeRepository;
import com.hgb7725.employee_rest_api.repository.ManagerRepository;
import com.hgb7725.employee_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ManagerRepository managerRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new ApiException("Employee not found with id: " + id, HttpStatus.NOT_FOUND)
        );
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        Manager savedManager = resolveManager(employee.getManager());
        employee.setManager(savedManager);
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Integer id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.deleteById(id);
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByManagerId(Integer managerId) {
        List<Employee> employees = employeeRepository.getEmployeesByManagerId(managerId);
        return employees;
    }

    @Override
    public Employee getEmployeeByEmployeeDetailId(Integer employeeDetailId) {
        Employee employee = employeeRepository.getEmployeeByEmployeeDetailId(employeeDetailId);
        if (employee == null) {
            throw new ApiException("Employee not found with employee detail id: " + employeeDetailId, HttpStatus.NOT_FOUND);
        }
        return employee;
    }

    private Manager resolveManager(Manager input) {
        if (input == null) return null;

        if (input.getId() != null) {
            return managerRepository.findById(input.getId())
                    .orElseThrow(() -> new ApiException("Manager with ID " + input.getId() + " not found", HttpStatus.NOT_FOUND));
        }

        return managerRepository.save(input);
    }

    private boolean hasManagerInfo(Manager manager) {
        return manager.getName() != null ||
                manager.getEmail() != null ||
                manager.getDepartment() != null;
    }
}
