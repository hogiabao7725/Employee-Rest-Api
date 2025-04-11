package com.hgb7725.employee_rest_api.service;

import com.hgb7725.employee_rest_api.entity.EmployeeDetail;

import java.util.List;

public interface EmployeeDetailService {

    EmployeeDetail getEmployeeDetailByEmployeeId(Integer id);

    List<EmployeeDetail> getAllEmployeeDetails();

    EmployeeDetail getEmployeeDetailById(Integer id);

    EmployeeDetail saveEmployeeDetail(EmployeeDetail employeeDetail);

    EmployeeDetail deleteEmployeeDetailById(Integer id);

}
