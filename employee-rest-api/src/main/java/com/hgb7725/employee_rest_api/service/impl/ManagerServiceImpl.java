package com.hgb7725.employee_rest_api.service.impl;

import com.hgb7725.employee_rest_api.entity.Manager;
import com.hgb7725.employee_rest_api.exception.ApiException;
import com.hgb7725.employee_rest_api.repository.ManagerRepository;
import com.hgb7725.employee_rest_api.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(int id) {
        return managerRepository.findById(id).orElseThrow(
                () -> new ApiException("Manager not found with id: " + id, HttpStatus.NOT_FOUND)
        );
    }

    @Override
    @Transactional
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    @Transactional
    public Manager deleteManager(int id) {
        Manager manager = managerRepository.findById(id).orElseThrow(
                () -> new ApiException("Manager not found with id: " + id, HttpStatus.NOT_FOUND)
        );
        managerRepository.deleteById(id);
        return manager;
    }
}
