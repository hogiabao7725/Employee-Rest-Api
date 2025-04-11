package com.hgb7725.employee_rest_api.repository.impl;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.repository.EmployeeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    private EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployeesSortByAgeASC() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.age ASC", Employee.class);
        return query.getResultList();
    }
}
