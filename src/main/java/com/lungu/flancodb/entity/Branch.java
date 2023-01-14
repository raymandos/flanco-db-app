package com.lungu.flancodb.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "branch")
public class Branch {

    @Id
    private String id;

    private String name;

    public Branch() {
        super();
    }
}