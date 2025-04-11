package com.hgb7725.employee_rest_api.controller;

import com.hgb7725.employee_rest_api.entity.Employee;
import com.hgb7725.employee_rest_api.entity.Manager;
import com.hgb7725.employee_rest_api.service.EmployeeService;
import com.hgb7725.employee_rest_api.service.ManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManagerController {

    private ManagerService managerService;
    private EmployeeService employeeService;

    @Autowired
    public ManagerController(ManagerService managerService, EmployeeService employeeService) {
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerService.getAllManagers();
        if (managers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable int id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @PostMapping("/managers")
    public ResponseEntity<Manager> saveManager(@Valid @RequestBody Manager manager) {
        manager.setId(null);
        Manager savedManager = managerService.saveManager(manager);

        URI location = URI.create("/api/v1/managers/" + savedManager.getId());

        return ResponseEntity.created(location).body(savedManager);
    }

    @PutMapping("/managers/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable int id, @Valid @RequestBody Manager manager) {
        manager.setId(id);
        Manager updatedManager = managerService.saveManager(manager);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/managers/{id}")
    public ResponseEntity<Manager> deleteManager(@PathVariable int id) {
        Manager manager = managerService.deleteManager(id);
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/managers/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByManagerId(@PathVariable Integer id) {
        List<Employee> employees = employeeService.getEmployeesByManagerId(id);
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

}
