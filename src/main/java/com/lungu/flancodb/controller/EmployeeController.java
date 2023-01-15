package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.models.EmployeeModel;
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
        List<EmployeeModel> employees = employeeService.getAllEmployeeModels();
        List<Department> departments = departmentService.getAllDepartments();
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("employees", employees);
        model.addAttribute("duplicate", duplicate);
        model.addAttribute("departments", departments);
        model.addAttribute("branches", branches);
        return "employees";
    }

    @PostMapping("/employees/add")
    public String createEmployee(@ModelAttribute("employee") final Employee employee) {
            employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id) throws EntityNotFoundException {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
    @GetMapping("/employees/update/{id}")
    public String getUpdateEmployee(Model model, @PathVariable("id") final String id) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "redirect:/employees";
    }
    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") String id) throws EntityNotFoundException {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
}
