package com.lungu.flancodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    private String id;

    private String name;

    private String address;

    private String telephone;

    private String birthdate;

    private Integer salary;

    private String department_id;

    private String branch_id;

    public Employee() {
        super();
    }
}
