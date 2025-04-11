package com.hgb7725.employee_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(name = "department")
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    @Column(name = "location")
    @NotEmpty(message = "Location cannot be empty")
    private String location;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "manager_id")
    @JsonBackReference
    private Manager manager;

    @Valid
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "employee_detail_id")
    private EmployeeDetail employeeDetail;

}
