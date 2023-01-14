package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("select d from Department d order by d.name")
    List<Department> findAllOrderByName();
}
