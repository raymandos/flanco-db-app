package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.entity.Product;
import com.lungu.flancodb.entity.Sales;
import com.lungu.flancodb.models.SalesModel;
import com.lungu.flancodb.service.BranchService;
import com.lungu.flancodb.service.ProductService;
import com.lungu.flancodb.service.SalesService;
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
public class SalesController {

    final SalesService salesService;
    final BranchService branchService;
    final ProductService productService;

    @GetMapping("/sales")
    public String getSales(Model model) {

        List<SalesModel> sales = salesService.getAllSalesModels();
        List<Branch> branches = branchService.getAllBranches();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("sales", sales);
        model.addAttribute("branches", branches);
        model.addAttribute("products", products);
        return "sales";
    }

    @PostMapping("/sales/add")
    public String createSale(@ModelAttribute("sales") final Sales sales) {
        salesService.saveSales(sales);
        return "redirect:/sales";
    }

    @GetMapping("/sales/delete/{id}")
    public String deleteSale(@PathVariable("id") String id) throws EntityNotFoundException {
        salesService.deleteSalesById(id);
        return "redirect:/sales";
    }

    @PostMapping("/sales/update/{id}")
    public String updateSale(@ModelAttribute("sales") Sales sales, @PathVariable("id") String id) throws EntityNotFoundException {
        salesService.saveSales(sales);
        return "redirect:/sales";
    }

}
