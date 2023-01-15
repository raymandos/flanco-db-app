package com.lungu.flancodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "sales")
public class Sales {

    @Id
    private String id;

    private Integer stock;

    private Integer sold;

    private String product_id;

    private String branch_id;

    public Sales() {
        super();
    }
}