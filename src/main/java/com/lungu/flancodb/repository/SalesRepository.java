package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {

    @Query("select p.id, p.name, p.price, p.description, s.id, s.stock, s.sold, p.name, b.name from Product p join Sales s on " +
            "s.product_id = p.id join Branch b on s.branch_id = b.id ")
    void displayProductsAndSales();



}
