package com.lungu.flancodb.repository;

import com.lungu.flancodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e from Employee e")
    List<Employee> findAll();
    @Query("select e from Employee e where e.id = ?1")
    Optional<Employee> findById(String id);
    @Modifying
    @Query("delete from Employee e where e.id = ?1")
    void deleteById(String id);

    @Modifying
    @Query(value = "insert into Employee (id, name, address, telephone, birthdate, salary, department_id, branch_id)" +
            "values(id, name, address, telephone, birthdate, salary, department_id, branch_id) ", nativeQuery = true)
    void saveEmployee(@Param("id") String id, @Param("name") String name, @Param("address") String address,
                      @Param("telephone") String telephone, @Param("birthdate") String birthdate, @Param("salary") Integer salary,
                      @Param("department_id") String department_id, @Param("branch_id") String branch_id);
}
