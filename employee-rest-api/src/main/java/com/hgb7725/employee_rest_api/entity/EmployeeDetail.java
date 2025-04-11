package com.hgb7725.employee_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "employee_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @Column(name = "phone")
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;

    @OneToOne(mappedBy = "employeeDetail", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JsonBackReference
    private Employee employee;

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
