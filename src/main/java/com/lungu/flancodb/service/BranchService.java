package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.repository.BranchRepository;
import com.lungu.flancodb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    final BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        List<Branch> result = branchRepository.findAllOrderByName();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }
}