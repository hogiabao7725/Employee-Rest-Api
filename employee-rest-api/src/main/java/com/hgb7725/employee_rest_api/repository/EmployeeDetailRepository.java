package com.hgb7725.employee_rest_api.repository;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Integer> {

    EmployeeDetail findByEmployeeId(Integer employeeId);

//    List<EmployeeDetail> getAllEmployeeDetails();
//
//    EmployeeDetail addEmployeeDetail(EmployeeDetail id);
//
//    EmployeeDetail updateEmployeeDetail(EmployeeDetail id);
//
//    EmployeeDetail deleteEmployeeDetail(Integer id);

}
