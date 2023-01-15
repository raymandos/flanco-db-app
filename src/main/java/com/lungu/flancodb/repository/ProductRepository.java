package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select p from Product p where p.id = ?1")
    Optional<Product> findProductById(String id);

    @Query("select p from Product p order by p.name")
    List<Product> findAllOrderByName();
}
