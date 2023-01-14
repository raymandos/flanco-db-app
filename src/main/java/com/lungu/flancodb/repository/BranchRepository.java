package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Department, String> {

    @Query("select b from Branch b order by b.name")
    List<Branch> findAllOrderByName();
}
