package com.lungu.flancodb.repository;

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
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e from Employee e order by e.name")
    List<Employee> findAll();
    @Query("select e from Employee e where e.branch_id in (select b.name from Branch b where b.id = e.branch_id) ")
    List<Employee> findAllWithBranch();
    @Query("select e from Employee e where e.department_id in (select d.name from Department d where d.id = e.department_id)")
    List<Employee> findAllWithDepartment();
    @Modifying
    @Query("update Employee e set e.id = ?1, e.name = ?2, e.address = ?3, e.telephone = ?4, e.birthdate=?5," +
            "e.salary = ?6, e.department_id = (select d.id from Department d where d.id = ?7)," +
            "e.branch_id = (select b.id from Branch b where b.id = ?8)")
    void updateById(String id, String name, String address, String telephone, String birthdate,Integer salary,
                    String department_id, String branch_id);
    @Query("select e from Employee e where e.id = ?1")
    Optional<Employee> findById(String id);
    @Modifying
    @Query("delete from Employee e where e.id = ?1")
    void deleteById(String id);

    @Transactional
    @Modifying
    @Query(value = "insert into Employee values(name, address, telephone, birthdate, salary, department_id, branch_id) ", nativeQuery = true)
    void saveEmployee(@Param("id") String id, @Param("name") String name, @Param("address") String address,
                      @Param("telephone") String telephone, @Param("birthdate") String birthdate, @Param("salary") Integer salary,
                      @Param("department_id") String department_id, @Param("branch_id") String branch_id);
}
