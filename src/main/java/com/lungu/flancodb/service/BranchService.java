package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.repository.BranchRepository;
import com.lungu.flancodb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchService {

    final BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        List<Branch> result = branchRepository.findAllOrderByName();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }

    public Branch getByName(String name) {
        return branchRepository.getBranchByName(name);
    }

    public void saveBranch(Branch branch) {
        branchRepository.save(branch);
//            branchRepository.saveBranch(employee.getId(), employee.getName(), employee.getAddress(), employee.getTelephone(),
//                    employee.getBirthdate(), employee.getSalary(), employee.getDepartment_id(), employee.getBranch_id());
    }

    public void deleteBranchById(String id)
            throws EntityNotFoundException {

        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            branchRepository.deleteBranchById(id);
        } else {
            throw new EntityNotFoundException
                    ("No employee record exists for this ID.");
        }
    }

    public Integer filterSalesByBranchId(String id) throws EntityNotFoundException {
        return branchRepository.getSalesByBranchId(id);
    }
}