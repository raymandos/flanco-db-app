package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        List<Department> result = departmentRepository.findAllOrderByName();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }
}
