package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.service.BranchService;
import com.lungu.flancodb.service.DepartmentService;
import com.lungu.flancodb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    final EmployeeService employeeService;
    final DepartmentService departmentService;
    final BranchService branchService;

    @GetMapping("/employees")
    public String getEmployees(Model model, @RequestParam(required = false) final Boolean duplicate) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Department> departments = departmentService.getAllDepartments();
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("employees", employees);
        model.addAttribute("duplicate", duplicate);
        model.addAttribute("departments", departments);
        model.addAttribute("branches", branches);
        return "home";
    }

    @GetMapping("/employees/create")
    public String getCreateEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "redirect:/employees";
    }
    @PostMapping("/employees/create")
    public String createEmployee(@ModelAttribute("employee") final Employee employee) {
        try {
            employeeService.saveEmployee(employee);
        } catch (Exception e) {
            return "redirect:/employees?duplicate=true";
        }
        return "redirect:/employees";
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id) throws EntityNotFoundException {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
