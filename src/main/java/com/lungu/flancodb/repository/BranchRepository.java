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
public interface BranchRepository extends JpaRepository<Branch, String> {

    @Query("select b from Branch b order by b.name")
    List<Branch> findAllOrderByName();
    Optional<Branch> findById(String id);
    @Query("select b from Branch b where b.name = ?1")
    Branch getBranchByName(String name);

    @Modifying
    @Query("delete from Branch b where b.id = ?1")
    void deleteBranchById(String id);

    @Query("select sum(s.sold) from Sales s join Branch b on b.id = s.branch_id")
    Integer getSalesByBranchId(String id);

    @Transactional
    @Modifying
    @Query(value = "insert into Branch values(id, name)", nativeQuery = true)
    void saveBranch(@Param("id") String id, @Param("name") String name);
}
