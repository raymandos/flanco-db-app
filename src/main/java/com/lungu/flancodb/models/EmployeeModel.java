package com.lungu.flancodb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String id;

    private String name;

    private String address;

    private String telephone;

    private String birthdate;

    private Integer salary;

    private String department_id;

    private String branch_id;

}