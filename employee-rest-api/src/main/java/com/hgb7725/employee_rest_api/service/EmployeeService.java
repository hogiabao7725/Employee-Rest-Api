package com.hgb7725.employee_rest_api.service;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.EmployeeDetail;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);

    Employee deleteEmployee(Integer id);

    List<Employee> getEmployeesByManagerId(Integer managerId);

    Employee getEmployeeByEmployeeDetailId(Integer employeeDetailId);

}
