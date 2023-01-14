package com.lungu.flancodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "department")
public class Department {

    @Id
    private String id;

    private String name;

    public Department() {
        super();
    }
}