package com.lungu.flancodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

    private String description;

    public Product() {
        super();
    }
}