package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        List<Department> result = departmentRepository.findAllOrderByName();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }

    public Department getByName(String name) {
        return departmentRepository.getDepartmentByName(name);
    }
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
//          departmentRepository.saveDepartment(employee.getId(), employee.getName(), employee.getAddress(), employee.getTelephone(),
//                    employee.getBirthdate(), employee.getSalary(), employee.getDepartment_id(), employee.getBranch_id());
    }

    public void deleteDepartmentById(String id)
            throws EntityNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("No department record exists for this ID.");
        }
    }

}
