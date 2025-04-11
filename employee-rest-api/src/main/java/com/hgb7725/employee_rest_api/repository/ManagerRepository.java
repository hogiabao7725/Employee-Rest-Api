package com.hgb7725.employee_rest_api.repository;

import com.hgb7725.employee_rest_api.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
