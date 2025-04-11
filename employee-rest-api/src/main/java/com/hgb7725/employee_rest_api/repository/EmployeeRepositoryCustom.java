package com.hgb7725.employee_rest_api.repository;

import com.hgb7725.employee_rest_api.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeRepositoryCustom {

    List<Employee> findAllEmployeesSortByAgeASC();

}
