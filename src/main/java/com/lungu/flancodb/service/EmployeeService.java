package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.models.EmployeeModel;
import com.lungu.flancodb.repository.BranchRepository;
import com.lungu.flancodb.repository.DepartmentRepository;
import com.lungu.flancodb.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final BranchRepository branchRepository;
    final DepartmentRepository departmentRepository;

    public List<EmployeeModel> getAllEmployeeModels() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (Employee employee : employees) {
            employeeModels.add(new EmployeeModel(
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getTelephone(),
                    employee.getBirthdate(),
                    employee.getSalary(),
                    departmentRepository.findById(employee.getDepartment_id()).get().getName(),
                    branchRepository.findById(employee.getBranch_id()).get().getName()
            ));
        }
        return employeeModels;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> result = employeeRepository.findAll();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }

    public Employee getEmployeeById(String id) throws EntityNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No customer found for this ID" + id));
    }

    public Boolean isDuplicate(Employee employee) {
        return employeeRepository.existsById(employee.getId());
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
//            employeeRepository.saveEmployee(employee.getId(), employee.getName(), employee.getAddress(), employee.getTelephone(),
//                    employee.getBirthdate(), employee.getSalary(), employee.getDepartment_id(), employee.getBranch_id());
    }

    public void deleteEmployeeById(String id)
            throws EntityNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("No employee record exists for this ID.");
        }
    }
}
