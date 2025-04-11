package com.hgb7725.employee_rest_api.repository;

import com.hgb7725.employee_rest_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom{
    List<Employee> getEmployeesByManagerId(Integer managerId);

    Employee getEmployeeByEmployeeDetailId(Integer id);
}
