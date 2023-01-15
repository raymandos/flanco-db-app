package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BranchController {

    final BranchService branchService;

    @GetMapping("/branches")
    public String getBranches(Model model, @RequestParam(required=false) final Integer filtered) {

        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("branches", branches);
        model.addAttribute("filtered", filtered);
        return "branches";
    }

    @PostMapping("/branches/add")
    public String createBranch(@ModelAttribute("branch") final Branch branch) {
        branchService.saveBranch(branch);
        return "redirect:/branches";
    }

    @PostMapping("/branches/update/{id}")
    public String updateBranch(@ModelAttribute("branch") Branch branch, @PathVariable("id") String id) throws EntityNotFoundException {
        branchService.saveBranch(branch);
        return "redirect:/branches";
    }

    @GetMapping("/branches/delete/{id}")
    public String deleteBranch(@PathVariable("id") String id) throws EntityNotFoundException {
        branchService.deleteBranchById(id);
        return "redirect:/branches";
    }

    @PostMapping("/branches/check-sales/{id}")
    public String checkSales(@PathVariable("id") String id) throws EntityNotFoundException {
        Integer filtered = branchService.filterSalesByBranchId(id);
        return "redirect:/branches?filtered=" + filtered;
    }
}
