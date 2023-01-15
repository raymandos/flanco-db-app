package com.lungu.flancodb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesModel {

    private String id;

    private Integer stock;

    private Integer sold;

    private String product_id;

    private String branch_id;
}
