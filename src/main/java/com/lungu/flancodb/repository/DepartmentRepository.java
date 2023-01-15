package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("select d from Department d order by d.name")
    List<Department> findAllOrderByName();

    Department getDepartmentByName(String name);

    Optional<Department> findById(String id);

    @Modifying
    @Query("delete from Department d where d.id = ?1")
    void deleteDepartmentById(String id);

    @Transactional
    @Modifying
    @Query(value = "insert into Department values(id, name)", nativeQuery = true)
    void saveDepartment(@Param("id") String id, @Param("name") String name);
}
