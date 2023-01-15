package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    final DepartmentService departmentService;

    @GetMapping("/departments")
    public String getDepartments(Model model) {

        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @PostMapping("/departments/add")
    public String createDepartment(@ModelAttribute("department") final Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @PostMapping("/departments/update/{id}")
    public String updateDepartment(@ModelAttribute("department") Department department, @PathVariable("id") String id) throws EntityNotFoundException {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteDepartments(@PathVariable("id") String id) throws EntityNotFoundException {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
}
