package com.hgb7725.employee_rest_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "manager")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(name = "email")
    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(name = "department")
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
    private List<Employee> employees;

}
