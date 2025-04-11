package com.hgb7725.employee_rest_api.service;

import com.hgb7725.employee_rest_api.entity.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManagers();

    Manager getManagerById(int id);

    Manager saveManager(Manager manager);

    Manager deleteManager(int id);

}
